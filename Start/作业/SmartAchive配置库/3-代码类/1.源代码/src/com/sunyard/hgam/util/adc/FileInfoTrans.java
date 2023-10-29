package com.sunyard.hgam.util.adc;

import java.util.*;
import java.io.*;
import java.net.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.*;

public class FileInfoTrans {
  //Fields
  public static final String ROOT_NAME = "文件信息";

  public static final String CATALOG_NAME_NODE_NAME = "目录名称";
  public static final String FILE_LIST_NODE_NAME = "文件列表";

  public static final String FILE_NODE_NAME = "文件";
  public static final String FILE_NODE_ATTR_NAME = "名称";
  public static final String FILE_NAME_NODE_NAME = "名称";
  public static final String FILE_SERIAL_NUMBER_NODE_NAME = "顺序号";
  public static final String FILE_IS_FRONT_NODE_NAME = "正反面";
  public static final String FILE_IS_IMAGE_NODE_NAME = "是否图象文件";
  public static final String FILE_IMAGE_NUBMER_NODE_NAME = "图象编号";

  //源XML文件名，即FileInfo.xml
  private String resourceXmlFileName;
  //目录名称
  private String catalogName;
  //所有文件信息
  private Hashtable fileInfo = new Hashtable();

  //构造函数
  public FileInfoTrans() {
  }

  public FileInfoTrans(String resourceXmlFileName) {
    this.resourceXmlFileName = resourceXmlFileName;
  }

  //设置
  public Hashtable getFileInfo() {
    return fileInfo;
  }

  public void setResourceXmlFileName(String resourceXmlFileName) {
    this.resourceXmlFileName = resourceXmlFileName;
  }

  public String getCatalogName() {
    return catalogName;
  }

  private Document getParsingDocument(String xmlFileName,
                                      boolean isparsingValid) throws Exception {
    Document rDocument = null;
    try {
      if (xmlFileName == null)
        return null;
      if (xmlFileName.equals(""))
        return null;
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating(isparsingValid);
      DocumentBuilder builder = factory.newDocumentBuilder();
      rDocument = builder.parse(new File(xmlFileName));
      rDocument.normalize();
    }
    catch (Exception e) {
      rDocument = null;
      throw e;
    }
    return rDocument;
  }

  private String getTextChild(Node node, String childNodeName) throws Exception {
    String retValue = "";
    try {
      if (node == null)
        return retValue;
      if (!node.hasChildNodes())
        return retValue;
      NodeList list = node.getChildNodes();
      for (int i = 0; i < list.getLength(); i++) {
        Node child = list.item(i);
        if (!child.getNodeName().equals(childNodeName))
          continue;
        else {
          if (!child.hasChildNodes())
            continue;
          for (int j = 0; j < child.getChildNodes().getLength(); j++) {
            if (! (child.getChildNodes().item(j).getNodeType() ==
                   Node.TEXT_NODE))
              continue;
            else {
              retValue = child.getChildNodes().item(j).getNodeValue();
              break;
            }
          }
        }
      }
    }
    catch (Exception e) {
      retValue = "";
      throw e;
    }
    return retValue;
  }

  private String getAttributeValue(Node node, String attributeName) throws
      Exception {
    String retValue = "";
    try {
      if (node == null)
        return retValue;
      if (!node.hasAttributes())
        return retValue;
      NamedNodeMap attributes = node.getAttributes();
      for (int i = 0; i < attributes.getLength(); i++) {
        Node childNode = attributes.item(i);
        if ( (childNode.getNodeType() == Node.ATTRIBUTE_NODE)) {
          if (childNode.getNodeName().equals(attributeName)) {
            retValue = childNode.getNodeValue();
          }
        }
      }
    }
    catch (Exception e) {
      retValue = "";
      throw e;
    }
    return retValue;
  }

  private Node getChildNodeByName(Node node, String childNodeName) throws
      Exception {
    Node retValue = null;
    try {
      if (node == null)
        return null;
      if (node.hasChildNodes()) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
          if (list.item(i).getNodeType() != Node.ELEMENT_NODE)
            continue;
          if (!list.item(i).getNodeName().equals(childNodeName))
            continue;
          else {
            retValue = list.item(i);
            break;
          }
        }
      }
    }
    catch (Exception e) {
      retValue = null;
    }
    return retValue;
  }

  private Node getChildNodeByNameAndIndex(Node node, String childNodeName,
                                          int index) throws Exception {
    Node retValue = null;
    try {
      if (node == null)
        return null;
      int flag = 0;
      if (node.hasChildNodes()) {
        NodeList list = node.getChildNodes();
        if (index < list.getLength()) {
          for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeType() != Node.ELEMENT_NODE)
              continue;
            if (!list.item(i).getNodeName().equals(childNodeName))
              continue;
            else {
              if (flag++ < index)
                continue;
              else {
                retValue = list.item(i);
                break;
              }
            }
          }
        }
      }
    }
    catch (Exception e) {
      retValue = null;
    }
    return retValue;
  }

  private Node getChildNodeByNameAndAttr(Node fatherNode, String childNodeName,
                                         String attrName, String attrValue) throws
      Exception {
    Node retValue = null;
    try {
      if (fatherNode == null)
        return retValue;
      if (!fatherNode.hasChildNodes())
        return retValue;
      else {

        for (int i = 0; i < fatherNode.getChildNodes().getLength(); i++) {
          Node childNode = this.getChildNodeByNameAndIndex(fatherNode,
              childNodeName, i);
          if (childNode.getNodeType() != Node.ELEMENT_NODE)
            continue;
          if (!childNode.hasAttributes())
            continue;
          NamedNodeMap attrList = childNode.getAttributes();
          Node attr = attrList.item(0);
          if ( (attr.getNodeType() != Node.ATTRIBUTE_NODE) ||
              !attr.getNodeName().equals(attrName) ||
              !attr.getNodeValue().equals(attrValue)) {
            continue;
          }
          else {
            retValue = childNode;
            break;
          }
        }
      }
    }
    catch (Exception e) {
      retValue = null;
      throw e;
    }
    return retValue;
  }

  private Vector getFileNodeInfo(Node fileNode) throws Exception {
    Vector retValue = new Vector();
    try {
      if (fileNode == null)
        return retValue;
      if (!fileNode.hasChildNodes())
        return retValue;
      retValue.addElement(this.getTextChild(fileNode, FILE_NAME_NODE_NAME));
      retValue.addElement(this.getTextChild(fileNode,
                                            FILE_SERIAL_NUMBER_NODE_NAME));
      retValue.addElement(this.getTextChild(fileNode, FILE_IS_FRONT_NODE_NAME));
      retValue.addElement(this.getTextChild(fileNode, FILE_IS_IMAGE_NODE_NAME));
      retValue.addElement(this.getTextChild(fileNode,
                                            FILE_IMAGE_NUBMER_NODE_NAME));
    }
    catch (Exception e) {
      retValue = new Vector();
      throw e;
    }
    return retValue;
  }

  public boolean TransToHashtable() throws Exception {
    boolean retValue = false;
    try {
      Document doc = this.getParsingDocument(this.resourceXmlFileName, false);
      if (!doc.getDocumentElement().getTagName().equals(ROOT_NAME))
        retValue = false;
      Node docElement = (Node) doc.getDocumentElement();
      //得到FileInfo.xml的目录名称
      this.catalogName = this.getTextChild(docElement,                                           CATALOG_NAME_NODE_NAME);
      //得到文件列表这个节点
      Node fileListNode = this.getChildNodeByName(docElement,                                                  FILE_LIST_NODE_NAME);
      NodeList fileNodeList = null;

      if (fileListNode.hasChildNodes()) {
        fileNodeList = doc.getElementsByTagName(FILE_NODE_NAME);
        for (int i = 0; i < fileNodeList.getLength(); i++) {
          this.fileInfo.put(Integer.toString(i),
                            this.getFileNodeInfo(fileNodeList.item(i)));
        }
      }
      retValue = true;
    }
    catch (Exception e) {
      this.catalogName = "";
      this.fileInfo = new Hashtable();
      retValue = false;
      throw e;
    }
    return retValue;
  }

  //
  public boolean storeResultTransToHashtable() throws Exception {
    boolean retValue = false;
    try {
      Document doc = this.getParsingDocument(this.resourceXmlFileName, false);
      if (!doc.getDocumentElement().getTagName().equals("StoreResult"))
        retValue = false;
      Node docElement = (Node) doc.getDocumentElement();

      //结果列表结点的父结点，即根结点
      Node fileListNode = this.getChildNodeByName(docElement, "StoreResult");
      NodeList fileNodeList = null;
      String sID, sCMID;

      fileNodeList = doc.getElementsByTagName("Row");
      for (int i = 0; i < fileNodeList.getLength(); i++) {
        NamedNodeMap attributes = fileNodeList.item(i).getAttributes();
        sID = "";
        sCMID = "";
        for (int j = 0; j < attributes.getLength(); j++) {
          Node childNode = attributes.item(j);
          if ( (childNode.getNodeType() == Node.ATTRIBUTE_NODE)) {
            if (childNode.getNodeName().equalsIgnoreCase("id"))
              sID = childNode.getNodeValue();
            if (childNode.getNodeName().equalsIgnoreCase("cmid"))
              sCMID = childNode.getNodeValue();
          }
        }
        this.fileInfo.put(sID, sCMID);
      }
      retValue = true;
    }
    catch (Exception e) {
      this.catalogName = "";
      this.fileInfo = new Hashtable();
      retValue = false;
      throw e;
    }
    return retValue;
  }

}