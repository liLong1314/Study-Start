package com.sunyard.hgam.util.common ;

/**
 * <p>Title: DOM��������װ��</p>
 * <p>Description: ��DOM��������һЩ���ܽ��з�װ</p>
 * <p>Copyright: Copyright (c) 2003.5.15</p>
 * <p>Company: �������Ŵ�ϵͳ���̹ɷ����޹�˾</p>
 * @author ����
 * @version 1.0 ----------------------------
 */

import java.io.*;
import java.util.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.*;

public class XmlParser
{
  /*----------------------------protected arguments----------------------------*/
  //XML�ļ���
  protected String xmlFileName;
  //�Ƿ����DTD��Ч�Լ��
  protected boolean isParsingValid=false;

  public Document thisDocument;

  public XmlParser()
  {
  }

  public XmlParser(String xmlFileName,boolean isParsingValid)
  {
      this.xmlFileName = xmlFileName;
      this.isParsingValid = isParsingValid;
  }

  /*----------------------------set/get functions----------------------------*/
  public void setXmlFileName(String aXmlFileName)  { this.xmlFileName = aXmlFileName; }
  public void setIsParsingValid(boolean aIsParsingValid)  { this.isParsingValid = aIsParsingValid;}
  public String getXmlFileName()  { return this.xmlFileName;}
  public boolean getIsParsingValid()  { return this.isParsingValid;}

  /*----------------------------private functions----------------------------*/
  /**
   * �����µ�doc����
   * @return Document
   * @throws Exception
   */
  private Document createDocument() throws Exception
  {
    Document rDocument=null;
    try
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      rDocument = builder.newDocument();
    }
    catch(Exception e)
    {
      rDocument = null;
      throw e;
    }
    return rDocument;
  }

  /**
   * �����ļ���ȡ�ĵ�����
   * @param aXmlFileName XML�ļ���
   * @param aIsparsingValid �Ƿ����dtd��Ч�Լ��
   * @return Document �ĵ�����
   * @throws Exception
   */
  public Document getParsingDocument(String aXmlFileName,boolean aIsparsingValid) throws Exception
  {
    Document rDocument=null;
    try
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating(aIsparsingValid);
      DocumentBuilder builder = factory.newDocumentBuilder();
      rDocument = builder.parse(new File(aXmlFileName));
      rDocument.normalize();
      this.thisDocument = rDocument;
    }
    catch(Exception e)
    {
      rDocument = null;
      throw e;
    }
    return rDocument;
  }

  public boolean saveDocument(String aXmlFileName,Document document) throws Exception
  {
    boolean retValue = false;
    try
    {
    TransformerFactory factory =TransformerFactory.newInstance();
    Transformer transformer = factory.newTransformer();
    DOMSource source = new DOMSource(document);
    StreamResult result = new StreamResult(new java.io.File(aXmlFileName));
    transformer.transform(source, result);
    retValue = true;
    }
    catch(Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ȡ�ڵ�������ӽڵ�����
   * @param node ����ڵ�
   * @return Vector �ӽڵ�����
   * @throws Exception
   */
  private Vector getChildNodesName(Node node) throws Exception
  {
    Vector rChildNodesName = new Vector();
    try
    {
      if (node.hasChildNodes())
      {
        NodeList nodeList = node.getChildNodes();
        if (nodeList.getLength()!=0)
        {
          for(int i=0;i<nodeList.getLength();i++)
          {
            Node tempItem = nodeList.item(i);
            if (tempItem.getNodeType()!=Node.ELEMENT_NODE) continue;
              rChildNodesName.addElement(tempItem.getNodeName());
          }
        }
      }
    }
    catch(Exception e)
    {
      rChildNodesName = new Vector();
      throw e;
    }
    return rChildNodesName;
  }

  /**
   * ��ȡ�ӽڵ�Ľڵ������������ͬ�Ľڵ�����ֻȡһ����
   * @param node ����ڵ�
   * @return Vector Ψһ���ӽڵ�����
   * @throws Exception
   */
  private Vector getUniqueChildNodesName(Node node) throws Exception
  {
    Vector rChildNodesName = new Vector();
    try
    {
      if (node.hasChildNodes())
      {
        NodeList nodeList = node.getChildNodes();
        if (nodeList.getLength()!=0)
        {
          for(int i=0;i<nodeList.getLength();i++)
          {
            Node tempItem = nodeList.item(i);
            if (tempItem.getNodeType()!=Node.ELEMENT_NODE) continue;
            {
              if (rChildNodesName.size() ==0)
                rChildNodesName.addElement(tempItem.getNodeName());
              else
              {
                for(int j=0;j<rChildNodesName.size();j++)
                {
                  if (tempItem.getNodeName().equals(rChildNodesName.elementAt(j))) continue;
                  rChildNodesName.addElement(tempItem.getNodeName());
                }
              }
            }
          }
        }
      }
    }
    catch(Exception e)
    {
      rChildNodesName = new Vector();
      throw e;
    }
    return rChildNodesName;
  }


  /**
   * ��ȡ���ı��ڵ�Ľڵ����ͽڵ��ı�ֵ�����ļ����£�
   * <FatherNode>
   *   <ChildNode1>Value1</ChildNode1>
   *   <ChildNode2>Value2</ChildNode2>
   * </FatherNode>
   * ����getChildTextNodeText(node,1)�����أ�[ChildNode2,Value2]
   * @param aFatherNode ���ڵ�
   * @param aChildNodeIndex �ӽڵ��ڸ��ڵ�����λ��
   * @return Vector �ӽڵ�����ֵ������[�ڵ������ı�ֵ]
   * @throws Exception
   */
  private Vector getChildTextNodeText(Node aFatherNode,int aChildNodeIndex) throws Exception
  {
    Vector rNodeText = new Vector();
    try
    {
      if (aFatherNode.hasChildNodes())
      {
        NodeList nodeList = aFatherNode.getChildNodes();
        if ((nodeList.getLength()!=0)&&(aChildNodeIndex<nodeList.getLength()))
        {
          Node tempItem = nodeList.item(aChildNodeIndex);
          String nodeText = "";
          if (tempItem.hasChildNodes())
            if (tempItem.getChildNodes().item(0).getNodeType()==Node.TEXT_NODE)
              nodeText = tempItem.getChildNodes().item(0).getNodeValue();
          rNodeText.addElement(tempItem.getNodeName());
          rNodeText.addElement(nodeText);
        }
      }
    }
    catch (Exception e)
    {
      rNodeText = new Vector();
      throw e;
    }
    return rNodeText;
  }

  /**
   * ���˿��ַ���
   * @param aString �����ַ���
   * @return String ��null���ַ����������null������""
   * @throws Exception
   */
  private String filterNull(String aString) throws Exception
  {
    if (aString==null)
      return "";
    else
      return aString;
  }

  /**
   * ���˿���ֵ
   * @param aInteger ������ֵ
   * @return Integer ��null����ֵ�������null������Integer���͵�0
   * @throws Exception
   */
  private Integer filterNull(Integer aInteger) throws Exception
  {
    if (aInteger==null)
      return Integer.getInteger("0");
    else
      return aInteger;
  }

  /*----------------------------public functions----------------------------*/

  /*----------------------------xmlCreate----------------------------*/
  /**
   * �����ļ������ļ�ͷ��Ϣ������XML�ĵ�
   * @param aXmlFileName XML�ļ���
   * @param aFileHead XML�ļ�ͷ
   * @param aDtdInformation �Ƿ���Ч�Լ������DTD�������
   * @param aRootElementName �ĵ���Ԫ�����ơ�
   * @return �����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean creatXmlFile(String aXmlFileName,String aFileHead,
                                 String aDtdInformation,String aRootElementName)throws Exception
  {
    boolean rSuccess = false;
    if (aRootElementName.equals("")||aXmlFileName.equals("")||aFileHead.equals(""))
      return false;
    try
    {

      File aFile = new File(aXmlFileName);
      aFile.delete();
      aFile.createNewFile();
      RandomAccessFile aRAFile = new RandomAccessFile(aFile,"rw");
      byte[] aBytesFileHead = aFileHead.getBytes();
      if(!aDtdInformation.trim().equals(""))
      {
        aBytesFileHead =(aFileHead+"\n"+aDtdInformation).getBytes();
      }
      aRAFile.write(aBytesFileHead);
      aRAFile.write(("\n"+"<"+aRootElementName+">\n</"+aRootElementName+">").getBytes());
      aRAFile.close();
      rSuccess = true;
    }
    catch (Exception e)
    {
      rSuccess = false;
      throw e;
    }
    return rSuccess;
  }

  /**
   * �����ļ������ļ�ͷ��Ϣ������XML�ĵ�
   * @param aXmlFileName XML�ļ���
   * @param aFileHead XML�ļ�ͷ
   * @param aDtdInformation �Ƿ���Ч�Լ������DTD�������
   * @param aRootElementName �ĵ���Ԫ�����ơ�
   * @return �����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean creatXmlFile(String aXmlFileName,String aFileHead,
                                 String aDtdInformation,String aRootElementName, String aRootText)throws Exception
  {
    boolean rSuccess = false;
    if (aRootElementName.equals("")||aXmlFileName.equals("")||aFileHead.equals(""))
      return false;
    try
    {

      File aFile = new File(aXmlFileName);
      aFile.delete();
      aFile.createNewFile();
      RandomAccessFile aRAFile = new RandomAccessFile(aFile,"rw");
      byte[] aBytesFileHead = aFileHead.getBytes();
      if(!aDtdInformation.trim().equals(""))
      {
        aBytesFileHead =(aFileHead+"\n"+aDtdInformation).getBytes();
      }
      aRAFile.write(aBytesFileHead);
      aRAFile.write(("\n"+"<"+aRootElementName+" "+aRootText+">\n</"+aRootElementName+">").getBytes());
      aRAFile.close();
      rSuccess = true;
    }
    catch (Exception e)
    {
      rSuccess = false;
      throw e;
    }
    return rSuccess;
  }

  /**
   * ��������XML�ļ�����һ���µ�XML�ļ�
   * @param aOldXmlFileName ԭ��XML�ļ�������ȫ·����
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNewXmlFileName ��XML�ļ�������ȫ·����
   * @return boolean �����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean cloneXmlFile(String aOldXmlFileName,boolean aIsParsingValid,String aNewXmlFileName) throws Exception
  {
    boolean retValue=false;
    try
    {
      Document document = getParsingDocument(aOldXmlFileName,aIsParsingValid);
      TransformerFactory factory =TransformerFactory.newInstance();
      Transformer transformer = factory.newTransformer();
      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult(new java.io.File(aNewXmlFileName));
      transformer.transform(source, result);
      retValue=true;
    }
    catch(Exception e)
    {
      retValue=false;
      throw e;
    }
    return retValue;
  }

  /*----------------------------xmlQuery----------------------------*/
  /**
   * ��ȡĳһ���ƵĽڵ��ڸ��ĵ��еĸ���
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @return int �ڵ����
   * @throws Exception
   */
  public int getNodeNumber(String aXmlFileName,boolean aIsParsingValid,
                           String aNodeName) throws Exception
  {
    int rNodeNumber = 0;
    try
    {
        if (!aXmlFileName.trim().equals(""))
        {
          Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
          if (doc!=null)
          {
            NodeList nodelist = doc.getElementsByTagName(aNodeName);
            rNodeNumber = nodelist.getLength();
          }
        }
    }
    catch (Exception e)
    {
        rNodeNumber=0;
        throw e;
    }
    return rNodeNumber;
  }

  /**
   * ��ȡĳһ���ƵĽڵ��ڸ��ĵ��еĸ���
   * @param aNodeName �ڵ���
   * @return int �ڵ����
   * @throws Exception
   */
  public int getNodeNumber(String aNodeName) throws Exception
  {
    int rNodeNumber = 0;
    try
    {
        if (!this.xmlFileName.trim().equals(""))
        {
          Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
          if (doc!=null)
          {
            NodeList nodelist = doc.getElementsByTagName(aNodeName);
            rNodeNumber = nodelist.getLength();
          }
        }
    }
    catch (Exception e)
    {
        rNodeNumber=0;
        throw e;
    }
    return rNodeNumber;
  }

  /**
   * ��ȡĳһ���ƵĽڵ��ڸ��ĵ��еĸ���
   * @param aNodeName �ڵ���
   * @return int �ڵ����
   * @throws Exception
   */
  public int getNodeNumber(Document doc,String aNodeName) throws Exception
  {
    int rNodeNumber = 0;
    try
    {
        if (!this.xmlFileName.trim().equals(""))
        {
          if (doc!=null)
          {
            NodeList nodelist = doc.getElementsByTagName(aNodeName);
            rNodeNumber = nodelist.getLength();
          }
        }
    }
    catch (Exception e)
    {
        rNodeNumber=0;
        throw e;
    }
    return rNodeNumber;
  }

  /**
   * ��ȡ���ڷ������ĵ��ĸ��ڵ�����
   * @return String ���ڵ�����
   * @throws Exception
   */
  public String getRootNodeName() throws Exception
  {
    String rRootNodeName="";
    try
    {
      if (!this.xmlFileName.trim().equals(""))
      {
        Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
        if (doc!=null)
        {
          Element rootElement = doc.getDocumentElement();
          rRootNodeName = rootElement.getTagName();
        }
      }
    }
    catch (Exception e)
    {
      rRootNodeName = "";
      throw e;
    }
    return rRootNodeName;
  }

  /**
   * ��ȡҪ������XML�ĵ��ĸ��ڵ�����
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @return String ���ڵ�����
   * @throws Exception
   */
  public String getRootNodeName(String aXmlFileName, boolean aIsParsingValid) throws Exception
  {
    String rRootNodeName="";
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      if (doc!=null)
      {
        Element rootElement = doc.getDocumentElement();
        rRootNodeName = rootElement.getTagName();
      }
    }
    catch (Exception e)
    {
      rRootNodeName = "";
      throw e;
    }
    return rRootNodeName;
  }

  /**
   * ��ȡXML�ĵ���ָ��λ�úͽڵ����Ľڵ��������������ֵ
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return Vector ��Ϊ[[������������ֵ]��[������������ֵ]��[������������ֵ]]
   * @throws Exception
   */
  public Vector getNodeAttributes(String aXmlFileName, boolean aIsParsingValid,
                                  String aNodeName,int aNodeIndex)throws Exception
  {
    Vector rAttributes = new Vector();
    Vector itemAttributes = new Vector();
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
          {
            itemAttributes.addElement(childNode.getNodeName());
            itemAttributes.addElement(childNode.getNodeValue());
            rAttributes.addElement(itemAttributes);
            itemAttributes = new Vector();
          }
        }
      }
    }
    catch (Exception e)
    {
      rAttributes = new Vector();
      throw e;
    }
    return rAttributes;
  }

  /**
   * ��ȡXML�ĵ���ָ��λ�úͽڵ����Ľڵ��������������ֵ
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return Vector ��Ϊ[[������������ֵ]��[������������ֵ]��[������������ֵ]]
   * @throws Exception
   */
  public Vector getNodeAttributes(String aNodeName,int aNodeIndex)throws Exception
  {
    Vector rAttributes = new Vector();
    Vector itemAttributes = new Vector();
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
          {
            itemAttributes.addElement(childNode.getNodeName());
            itemAttributes.addElement(childNode.getNodeValue());
            rAttributes.addElement(itemAttributes);
            itemAttributes = new Vector();
          }
        }
      }
    }
    catch (Exception e)
    {
      rAttributes = new Vector();
      throw e;
    }
    return rAttributes;
  }

  /**
   * ��ȡ�����ı��ڵ��������ı��ڵ���ı�ֵ��ȡ���з��������Ľڵ����ԣ��ĵ����£�
   * <QUERY>
   *   <node ������1="����ֵ1" ������2="����ֵ2">value</node>
   *   <node ������1="����ֵ3" ������2="����ֵ4">value</node>
   * </QUERY>
   * ���������aNodeName="node",aNodeText="value"
   * ���أ�{���1=[[������1,����ֵ3],[������2,����ֵ4]],���0=[[������1,����ֵ1],[������2,����ֵ2]]}
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeText �ı��ڵ���ı�ֵ
   * @return Hashtable ��Ϊ{���1=[[������,����ֵ],[������,����ֵ]],
   *                        ���0=[[������,����ֵ],[������,����ֵ]]}
   * @throws Exception
   */
  public Hashtable getNodeAttributes(String aXmlFileName, boolean aIsParsingValid,
                                     String aNodeName,String aNodeText)throws Exception
  {
    int index =0;
    Hashtable rAttributes = new Hashtable();
    Vector rAttribute = new Vector();
    Vector itemAttributes = new Vector();
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (0<(list.getLength()))
      {
        for(int i=0;i<list.getLength();i++)
        {
          Node node = list.item(i);
          if (node.hasChildNodes())
          {
            NodeList childList = node.getChildNodes();
            for(int j=0;j<childList.getLength();j++)
            {
              Node childNode = childList.item(j);
              if ((childNode.getNodeType()==Node.TEXT_NODE)&&childNode.getNodeValue().equals(aNodeText))
              {
                NamedNodeMap attributes = node.getAttributes();
                for(int k=0;k<attributes.getLength();k++)
                {
                  Node attrNode = attributes.item(k);
                  if ((attrNode.getNodeType()==Node.ATTRIBUTE_NODE))
                  {
                    itemAttributes.addElement(attrNode.getNodeName());
                    itemAttributes.addElement(attrNode.getNodeValue());
                    rAttribute.addElement(itemAttributes);
                    itemAttributes = new Vector();
                  }
                }
                rAttributes.put(Integer.toString(index),rAttribute);
                index++;
                rAttribute = new Vector();
              }
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      rAttributes = new Hashtable();
      throw e;
    }
    return rAttributes;
  }

  /**
   * ��ȡ�����ı��ڵ��������ı��ڵ���ı�ֵ��ȡ���з��������Ľڵ����ԣ��ĵ����£�
   * <QUERY>
   *   <node ������1="����ֵ1" ������2="����ֵ2">value</node>
   *   <node ������1="����ֵ3" ������2="����ֵ4">value</node>
   * </QUERY>
   * ���������aNodeName="node",aNodeText="value"
   * ���أ�{���1=[[������1,����ֵ3],[������2,����ֵ4]],���0=[[������1,����ֵ1],[������2,����ֵ2]]}
   * @param aNodeName �ڵ���
   * @param aNodeText �ı��ڵ���ı�ֵ
   * @return Hashtable ��Ϊ{���1=[[������,����ֵ],[������,����ֵ]],
   *                        ���0=[[������,����ֵ],[������,����ֵ]]}
   * @throws Exception
   */
  public Hashtable getNodeAttributes(String aNodeName,String aNodeText)throws Exception
  {
    int index =0;
    Hashtable rAttributes = new Hashtable();
    Vector rAttribute = new Vector();
    Vector itemAttributes = new Vector();
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (0<(list.getLength()))
      {
        for(int i=0;i<list.getLength();i++)
        {
          Node node = list.item(i);
          if (node.hasChildNodes())
          {
            NodeList childList = node.getChildNodes();
            for(int j=0;j<childList.getLength();j++)
            {
              Node childNode = childList.item(j);
              if ((childNode.getNodeType()==Node.TEXT_NODE)&&childNode.getNodeValue().equals(aNodeText))
              {
                NamedNodeMap attributes = node.getAttributes();
                for(int k=0;k<attributes.getLength();k++)
                {
                  Node attrNode = attributes.item(k);
                  if ((attrNode.getNodeType()==Node.ATTRIBUTE_NODE))
                  {
                    itemAttributes.addElement(attrNode.getNodeName());
                    itemAttributes.addElement(attrNode.getNodeValue());
                    rAttribute.addElement(itemAttributes);
                    itemAttributes = new Vector();
                  }
                }
                rAttributes.put(Integer.toString(index),rAttribute);
                index++;
                rAttribute = new Vector();
              }
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      rAttributes = new Hashtable();
      throw e;
    }
    return rAttributes;
  }

  /**
   * ȡ�������ӽڵ�����ԣ����ĵ����£�
   * <QUERY>
   * 	<SELECT>
                <SourceTable name="SourceTable1" value="asdf">
                        <RowName>ST1_row_1</RowName>
                        <RowName>ST1_row_2</RowName>
                </SourceTable>
                <SourceTable name="SourceTable2">
                        <RowName>ST2_row_1</RowName>
                        <RowName>ST2_row_2</RowName>
                </SourceTable>
                <SourceTable name="SourceTable3">
                        <RowName>*</RowName>
                </SourceTable>
        </SELECT>
     </QUERY>
   * �����ֱ�Ϊ���ļ�����false��true��SELECT��0
   * ���ؽ����{2=[[name, SourceTable3]], 1=[[name, SourceTable2]], 0=[[name, SourceTable1], [value, asdf]]}
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return Hashtable ��Ϊ {�ڵ�λ��=[[������,����ֵ]��[������,����ֵ]],�ڵ�λ��=[[������,����ֵ]��[������,����ֵ]]}
   * @throws Exception
   */
  public Hashtable getChildNodesAttributes(String aXmlFileName, boolean aIsParsingValid,
                                           String aNodeName,int aNodeIndex) throws Exception
  {
    Hashtable retValue = new Hashtable();
    Vector rAttributes = new Vector();
    Vector itemAttributes = new Vector();
    int k=0;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          NodeList childlist = node.getChildNodes();
          for(int i=0;i<childlist.getLength();i++)
          {
            if (childlist.item(i).getNodeType()!=Node.ELEMENT_NODE) continue;
            NamedNodeMap attributes = childlist.item(i).getAttributes();
            for(int j=0;j<attributes.getLength();j++)
            {
              Node childNode = attributes.item(j);
              if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
              {
                itemAttributes.addElement(childNode.getNodeName());
                itemAttributes.addElement(childNode.getNodeValue());
                rAttributes.addElement(itemAttributes);
                itemAttributes = new Vector();
              }
            }
            retValue.put(Integer.toString(k++),rAttributes);
            rAttributes = new Vector();
          }
        }
      }
    }
    catch (Exception e)
    {
      retValue = new Hashtable();
      throw e;
    }
    return retValue;
  }

  /**
   * ȡ�������ӽڵ�����ԣ����ĵ����£�
   * <QUERY>
   * 	<SELECT>
                <SourceTable name="SourceTable1" value="asdf">
                        <RowName>ST1_row_1</RowName>
                        <RowName>ST1_row_2</RowName>
                </SourceTable>
                <SourceTable name="SourceTable2">
                        <RowName>ST2_row_1</RowName>
                        <RowName>ST2_row_2</RowName>
                </SourceTable>
                <SourceTable name="SourceTable3">
                        <RowName>*</RowName>
                </SourceTable>
        </SELECT>
     </QUERY>
   * �����ֱ�Ϊ���ļ�����false��true��SELECT��0
   * ���ؽ����{2=[[name, SourceTable3]], 1=[[name, SourceTable2]], 0=[[name, SourceTable1], [value, asdf]]}
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return Hashtable ��Ϊ {�ڵ�λ��=[[������,����ֵ]��[������,����ֵ]],�ڵ�λ��=[[������,����ֵ]��[������,����ֵ]]}
   * @throws Exception
   */
  public Hashtable getChildNodesAttributes(String aNodeName,int aNodeIndex) throws Exception
  {
    Hashtable retValue = new Hashtable();
    Vector rAttributes = new Vector();
    Vector itemAttributes = new Vector();
    int k=0;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          NodeList childlist = node.getChildNodes();
          for(int i=0;i<childlist.getLength();i++)
          {
            if (childlist.item(i).getNodeType()!=Node.ELEMENT_NODE) continue;
            NamedNodeMap attributes = childlist.item(i).getAttributes();
            for(int j=0;j<attributes.getLength();j++)
            {
              Node childNode = attributes.item(j);
              if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
              {
                itemAttributes.addElement(childNode.getNodeName());
                itemAttributes.addElement(childNode.getNodeValue());
                rAttributes.addElement(itemAttributes);
                itemAttributes = new Vector();
              }
            }
            retValue.put(Integer.toString(k++),rAttributes);
            rAttributes = new Vector();
          }
        }
      }
    }
    catch (Exception e)
    {
      retValue = new Hashtable();
      throw e;
    }
    return retValue;
  }

  /**
   * ����ָ���ڵ��ȡ�ýڵ�ָ��������������ֵ
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aAttributeName ������
   * @return String ����ֵ
   * @throws Exception
   */
  public String getAttributeValue(String aXmlFileName, boolean aIsParsingValid,
                                  String aNodeName,int aNodeIndex,String aAttributeName) throws Exception
  {
    String rAttributeValue="";
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<list.getLength())
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE)&&(childNode.getNodeName().equals(aAttributeName)))
          {
            rAttributeValue=filterNull(childNode.getNodeValue());
          }
        }
      }
    }
    catch (Exception e)
    {
      rAttributeValue="";
      throw e;
    }
    return rAttributeValue;
  }

  /**
   * ����ָ���ڵ��ȡ�ýڵ�ָ��������������ֵ
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aAttributeName ������
   * @return String ����ֵ
   * @throws Exception
   */
  public String getAttributeValue(String aNodeName,int aNodeIndex,String aAttributeName) throws Exception
  {
    String rAttributeValue="";
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<list.getLength())
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE)&&(childNode.getNodeName().equals(aAttributeName)))
          {
            rAttributeValue=filterNull(childNode.getNodeValue());
          }
        }
      }
    }
    catch (Exception e)
    {
      rAttributeValue="";
      throw e;
    }
    return rAttributeValue;
  }

  /**
   * ��ȡXML�ĵ��ж�Ӧ�ڵ���ı�����<Test>aaa</Test>��aNodeNameΪTest,
   * aNodeIndexָ����ڵ����ĵ���������λ��
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ�������λ��
   * @return String �ýڵ��ڵ��ı�����
   * @throws Exception
   */
  public String getTextNodeText(String aXmlFileName,boolean aIsParsingValid,
                             String aNodeName,int aNodeIndex) throws Exception
  {
    String rNodeValue = "";
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          Node childNode = node.getChildNodes().item(0);
          if ((childNode.getNodeType()==Node.TEXT_NODE))
          {
            rNodeValue = childNode.getNodeValue();
          }
        }
        else
        {
          rNodeValue = "";
        }
      }
    }
    catch (Exception e)
    {
      rNodeValue = "";
      throw e;
    }
    return rNodeValue;
  }

  /**
   * ��ȡXML�ĵ��ж�Ӧ�ڵ���ı�����<Test>aaa</Test>��aNodeNameΪTest,
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ�������λ��
   * @return String �ýڵ��ڵ��ı�����
   * @throws Exception
   */
  public String getTextNodeText(String aNodeName,int aNodeIndex) throws Exception
  {
    String rNodeValue = "";
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<list.getLength())
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          Node childNode = node.getChildNodes().item(0);
          if ((childNode.getNodeType()==Node.TEXT_NODE))
          {
            rNodeValue = childNode.getNodeValue();
          }
        }
        else
        {
          rNodeValue = "";
        }
      }
    }
    catch (Exception e)
    {
      rNodeValue = "";
      throw e;
    }
    return rNodeValue;
  }

  /**
   * ��ȡXML�ĵ��еĶ�Ӧָ��λ�ýڵ��������ӽڵ������
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex �ڼ������ڵ�
   * @return �ýڵ������е��ӽڵ�����
   * @throws Exception
   */
  public Vector getChildNodesName(String aXmlFileName,boolean aIsParsingValid,
                                  String aFatherNodeName,int aFatherNodeIndex) throws Exception
  {
     Vector rChildNodesName = new Vector();
     try
     {
       Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
       NodeList list = doc.getElementsByTagName(aFatherNodeName);
       if (aFatherNodeIndex<list.getLength())
       {
         Node node = list.item(aFatherNodeIndex);
         rChildNodesName = getChildNodesName(node);
       }
     }
     catch(Exception e)
     {
       rChildNodesName = new Vector();
       throw e;
     }
     return rChildNodesName;
  }

  /**
   * ��ȡXML�ĵ��еĶ�Ӧָ��λ�ýڵ��������ӽڵ������
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex �ڼ������ڵ�
   * @return �ýڵ������е��ӽڵ�����
   * @throws Exception
   */
  public Vector getChildNodesName(String aFatherNodeName,int aFatherNodeIndex) throws Exception
  {
     Vector rChildNodesName = new Vector();
     try
     {
       Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
       NodeList list = doc.getElementsByTagName(aFatherNodeName);
       if (aFatherNodeIndex<list.getLength())
       {
         Node node = list.item(aFatherNodeIndex);
         rChildNodesName = getChildNodesName(node);
       }
     }
     catch(Exception e)
     {
       rChildNodesName = new Vector();
       throw e;
     }
     return rChildNodesName;
  }

  /**
   * ��ȡXML�ĵ��еĶ�Ӧָ��λ�ýڵ��������ӽڵ�����ƣ�����ֻȡΨһֵ
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex �ڼ������ڵ�
   * @return �ýڵ������е��ӽڵ����ƣ���������Ψһ�ġ�
   * @throws Exception
   */
  public Vector getUniqueChildNodesName(String aXmlFileName,boolean aIsParsingValid,
                                        String aFatherNodeName,int aFatherNodeIndex) throws Exception
  {
     Vector rChildNodesName = new Vector();
     try
     {
       Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
       NodeList list = doc.getElementsByTagName(aFatherNodeName);
       if (aFatherNodeIndex<list.getLength())
       {
         Node node = list.item(aFatherNodeIndex);
         rChildNodesName = getUniqueChildNodesName(node);
       }
     }
     catch(Exception e)
     {
       rChildNodesName = new Vector();
       throw e;
     }
     return rChildNodesName;
  }

  /**
   * ��ȡXML�ĵ��еĶ�Ӧָ��λ�ýڵ��������ӽڵ�����ƣ�����ֻȡΨһֵ
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex �ڼ������ڵ�
   * @return �ýڵ������е��ӽڵ����ƣ���������Ψһ�ġ�
   * @throws Exception
   */
  public Vector getUniqueChildNodesName(String aFatherNodeName,int aFatherNodeIndex) throws Exception
  {
     Vector rChildNodesName = new Vector();
     try
     {
       Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
       NodeList list = doc.getElementsByTagName(aFatherNodeName);
       if (aFatherNodeIndex<list.getLength())
       {
         Node node = list.item(aFatherNodeIndex);
         rChildNodesName = getUniqueChildNodesName(node);
       }
     }
     catch(Exception e)
     {
       rChildNodesName = new Vector();
       throw e;
     }
     return rChildNodesName;
  }

  /**
   * ��ȡ�������ı��ڵ�Ľڵ����ͽڵ�ֵ�����ļ����£�
   * <FatherNode/>
   * <FatherNode>
   *   <ChildNode1>Value1</ChildNode1>
   *   <ChildNode2>Value2</ChildNode2>
   * </FatherNode>
   * ����getAllChildTextNodesText(FatherNode,1)�����أ�[[ChildNode1,Value1],[ChildNode2,Value2]]
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ���
   * @param aFatherNodeIndex ���ڵ����ĵ���������λ��
   * @return Vector ����[[�ڵ������ı�ֵ]��[�ڵ������ı�ֵ]��[�ڵ������ı�ֵ]]
   * @throws Exception
   */
  public Vector getAllChildTextNodesText(String aXmlFileName,boolean aIsParsingValid,
                                         String aFatherNodeName,int aFatherNodeIndex) throws Exception
  {
    Vector rTextVector = new Vector();
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<list.getLength())
      {
        Node node = list.item(aFatherNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if (node.getChildNodes().item(i).getNodeType()!=Node.ELEMENT_NODE) continue;
            rTextVector.addElement(getChildTextNodeText(node,i));
          }
        }
      }
    }
    catch(Exception e)
    {
      rTextVector = new Vector();
      throw e;
    }
    return rTextVector;
  }

  /**
   * ��ȡ�������ı��ڵ�Ľڵ����ͽڵ�ֵ�����ļ����£�
   * <FatherNode/>
   * <FatherNode>
   *   <ChildNode1>Value1</ChildNode1>
   *   <ChildNode2>Value2</ChildNode2>
   * </FatherNode>
   * ����getAllChildTextNodesText(FatherNode,1)�����أ�[[ChildNode1,Value1],[ChildNode2,Value2]]
   * @param aFatherNodeName ���ڵ���
   * @param aFatherNodeIndex ���ڵ����ĵ���������λ��
   * @return Vector ����[[�ڵ������ı�ֵ]��[�ڵ������ı�ֵ]��[�ڵ������ı�ֵ]]
   * @throws Exception
   */
  public Vector getAllChildTextNodesText(String aFatherNodeName,int aFatherNodeIndex) throws Exception
  {
    Vector rTextVector = new Vector();
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<list.getLength())
      {
        Node node = list.item(aFatherNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if (node.getChildNodes().item(i).getNodeType()!=Node.ELEMENT_NODE) continue;
            rTextVector.addElement(getChildTextNodeText(node,i));
          }
        }
      }
    }
    catch(Exception e)
    {
      rTextVector = new Vector();
      throw e;
    }
    return rTextVector;
  }

  /*----------------------------xmlUpdate----------------------------*/
  /**
   * ��ָ�������һ�����ڵ����һ���ӽڵ㡣
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ӽڵ�����
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildNode(String aXmlFileName, boolean aIsParsingValid ,
                              String aFatherNodeName,String aNodeName) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        fatherNode.appendChild(element);
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ���ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ӽڵ�����
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildNode(String aFatherNodeName,String aNodeName) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        fatherNode.appendChild(element);
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ���ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ӽڵ�����
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildNode(Document doc, String aFatherNodeName,String aNodeName) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")) return retValue;
    try
    {
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        fatherNode.appendChild(element);
        retValue = true;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ�������Ե��ӽڵ㡣
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ӽڵ�����
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildNode(String aXmlFileName, boolean aIsParsingValid ,
                              String aFatherNodeName,String aNodeName,
                              Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aAttributesNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||(aAttributesNameValue.size()==0))
      return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        fatherNode.appendChild(element);
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ�������Ե��ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ӽڵ�����
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildNode(String aFatherNodeName,String aNodeName,
                              Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aAttributesNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||(aAttributesNameValue.size()==0))
      return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        fatherNode.appendChild(element);
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ�������Ե��ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ӽڵ�����
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildNode(Document doc,String aFatherNodeName,String aNodeName,
                              Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aAttributesNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||(aAttributesNameValue.size()==0))
      return retValue;
    try
    {
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        fatherNode.appendChild(element);
        retValue = true;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ���ӽڵ㡣
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ӽڵ����ƣ���Vector������[�ӽڵ���1���ӽڵ���2]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildNodes(String aXmlFileName, boolean aIsParsingValid ,
                               String aFatherNodeName,Vector aNodeName) throws Exception
  {
    boolean retValue = false;
    if (aNodeName==null) return retValue;
    if (aFatherNodeName.equals("")||(aNodeName.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        for(int i=0;i<aNodeName.size();i++)
        {
          Element element = doc.createElement((String)aNodeName.elementAt(i));
          fatherNode.appendChild(element);
        }
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ���ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ӽڵ����ƣ���Vector������[�ӽڵ���1���ӽڵ���2]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildNodes(String aFatherNodeName,Vector aNodeName) throws Exception
  {
    boolean retValue = false;
    if (aNodeName==null) return retValue;
    if (aFatherNodeName.equals("")||(aNodeName.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        for(int i=0;i<aNodeName.size();i++)
        {
          Element element = doc.createElement((String)aNodeName.elementAt(i));
          fatherNode.appendChild(element);
        }
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ���ı��ӽڵ㡣
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildTextNode(String aXmlFileName, boolean aIsParsingValid ,
                                  String aFatherNodeName,String aNodeName,
                                  String aNodeValue) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||aNodeValue.equals("")) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ���ı��ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildTextNode(String aFatherNodeName,String aNodeName,
                                  String aNodeValue) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||aNodeValue.equals("")) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ���ı��ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildTextNode(Document doc,String aFatherNodeName,String aNodeName,
                                  String aNodeValue) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||aNodeValue.equals("")) return retValue;
    try
    {
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        retValue = true;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ���ı��ӽڵ㡣
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeNameValue [[�ı��ڵ��ǣ��ı�]��[�ı��ڵ��ǣ��ı�]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildTextNodes(String aXmlFileName, boolean aIsParsingValid ,
                                   String aFatherNodeName,Vector aNodeNameValue) throws Exception
  {
    boolean retValue = false;
    if (aNodeNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||(aNodeNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        for(int i=0;i<aNodeNameValue.size();i++)
        {
          Element element = doc.createElement((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(0));
          Text text = doc.createTextNode((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(0));
          text.setData((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(1));
          element.appendChild(text);
          fatherNode.appendChild(element);
        }
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ���ı��ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeNameValue [[�ı��ڵ��ǣ��ı�]��[�ı��ڵ��ǣ��ı�]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildTextNodes(String aFatherNodeName,Vector aNodeNameValue) throws Exception
  {
    boolean retValue = false;
    if (aNodeNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||(aNodeNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        for(int i=0;i<aNodeNameValue.size();i++)
        {
          Element element = doc.createElement((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(0));
          Text text = doc.createTextNode((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(0));
          text.setData((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(1));
          element.appendChild(text);
          fatherNode.appendChild(element);
        }
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ�������Ե��ı��ӽڵ㡣
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildTextNode(String aXmlFileName, boolean aIsParsingValid ,
                                  String aFatherNodeName,String aNodeName,
                                  String aNodeValue,Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aAttributesNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||aNodeValue.equals("")
        ||(aAttributesNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ�������Ե��ı��ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildTextNode(String aFatherNodeName,String aNodeName,
                                  String aNodeValue,Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aAttributesNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||aNodeValue.equals("")
        ||(aAttributesNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ�������һ�����ڵ����һ�������Ե��ı��ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addChildTextNode(Document doc,String aFatherNodeName,String aNodeName,
                                  String aNodeValue,Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aAttributesNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||aNodeValue.equals("")
        ||(aAttributesNameValue.size()==0)) return retValue;
    try
    {
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (fatherNodeList.getLength()>0)
      {
        Node fatherNode = fatherNodeList.item(fatherNodeList.getLength()-1);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        retValue = true;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }
  /**
   * ��ָ��λ�õĽڵ�������ԣ�������Դ�����ı�����ֵ
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addNodeAttributes(String aXmlFileName,boolean aIsParsingValid,
                                   String aNodeName,int aNodeIndex,
                                   Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)||(aAttributesNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList nodeList = doc.getElementsByTagName(aNodeName);
      if(aNodeIndex<nodeList.getLength())
      {
        Element element = (Element)nodeList.item(aNodeIndex);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�õĽڵ�������ԣ�������Դ�����ı�����ֵ
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean addNodeAttributes(String aNodeName,int aNodeIndex,
                                   Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)||(aAttributesNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList nodeList = doc.getElementsByTagName(aNodeName);
      if(aNodeIndex<nodeList.getLength())
      {
        Element element = (Element)nodeList.item(aNodeIndex);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�õ��ı��ڵ�����ı���������ı����ڣ���׷����ĩβ
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aNodeText Ҫ��ӵ��ı�
   * @return
   * @throws Exception
   */
  public boolean addNodeText(String aXmlFileName,boolean aIsParsingValid,
                             String aNodeName,int aNodeIndex,
                             String aNodeText) throws Exception
  {
    boolean retValue = false;
    if(aNodeName.equals("")||(aNodeIndex<0)||aNodeText.equals("")) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList nodeList = doc.getElementsByTagName(aNodeName);
      if(aNodeIndex<nodeList.getLength())
      {
        Node node = nodeList.item(aNodeIndex);
        Text text = doc.createTextNode(aNodeText);
        text.setData(aNodeText);
        node.appendChild(text);
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�õ��ı��ڵ�����ı���������ı����ڣ���׷����ĩβ
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aNodeText Ҫ��ӵ��ı�
   * @return
   * @throws Exception
   */
  public boolean addNodeText(String aNodeName,int aNodeIndex,
                             String aNodeText) throws Exception
  {
    boolean retValue = false;
    if(aNodeName.equals("")||(aNodeIndex<0)||aNodeText.equals("")) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList nodeList = doc.getElementsByTagName(aNodeName);
      if(aNodeIndex<nodeList.getLength())
      {
        Node node = nodeList.item(aNodeIndex);
        Text text = doc.createTextNode(aNodeText);
        text.setData(aNodeText);
        node.appendChild(text);
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò������ӽڵ�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeName �ӽڵ�����
   * @return boolean �����ӽڵ��Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildNode(String aXmlFileName,boolean aIsParsingValid,
                                 String aFatherNodeName,int aFatherNodeIndex,
                                 String aNodeName) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||(aFatherNodeIndex<0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList nodeList = doc.getElementsByTagName(aFatherNodeName);
      if(aFatherNodeIndex<nodeList.getLength())
      {
        Node node = nodeList.item(aFatherNodeIndex);
        Element element = doc.createElement(aNodeName);
        node.appendChild(element);
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò������ӽڵ�
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeName �ӽڵ�����
   * @return boolean �����ӽڵ��Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildNode(String aFatherNodeName,int aFatherNodeIndex,
                                 String aNodeName) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||(aFatherNodeIndex<0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList nodeList = doc.getElementsByTagName(aFatherNodeName);
      if(aFatherNodeIndex<nodeList.getLength())
      {
        Node node = nodeList.item(aFatherNodeIndex);
        Element element = doc.createElement(aNodeName);
        node.appendChild(element);
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò�������Ե����ӽڵ�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeName �ӽڵ�����
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean �����ӽڵ��Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildNode(String aXmlFileName,boolean aIsParsingValid,
                                 String aFatherNodeName,int aFatherNodeIndex,
                                 String aNodeName, Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||(aFatherNodeIndex<0)||(aAttributesNameValue.size()==0))
      return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList nodeList = doc.getElementsByTagName(aFatherNodeName);
      if(aFatherNodeIndex<nodeList.getLength())
      {
        Node node = nodeList.item(aFatherNodeIndex);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        node.appendChild(element);
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò�������Ե����ӽڵ�
   * @param aFatherNodeName ���ڵ�����
   * @param aNodeIndex ���ڵ�λ��
   * @param aNodeName �ӽڵ�����
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean �����ӽڵ��Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildNode(String aFatherNodeName,int aFatherNodeIndex,
                                 String aNodeName, Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||aNodeName.equals("")||(aFatherNodeIndex<0)||(aAttributesNameValue.size()==0))
      return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList nodeList = doc.getElementsByTagName(aFatherNodeName);
      if(aFatherNodeIndex<nodeList.getLength())
      {
        Node node = nodeList.item(aFatherNodeIndex);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        node.appendChild(element);
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�õĸ��ڵ����һ���ӽڵ㡣
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeName �ӽڵ����ƣ���Vector������[�ӽڵ���1���ӽڵ���2]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildNodes(String aXmlFileName,boolean aIsParsingValid,
                                  String aFatherNodeName,int aFatherNodeIndex,
                                  Vector aNodeName) throws Exception
  {
    boolean retValue = false;
    if (aNodeName==null) return retValue;
    if (aFatherNodeName.equals("")||(aNodeName.size()==0)||(aFatherNodeIndex<0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<fatherNodeList.getLength())
      {
        Node fatherNode = fatherNodeList.item(aFatherNodeIndex);
        for(int i=0;i<aNodeName.size();i++)
        {
          Element element = doc.createElement((String)aNodeName.elementAt(i));
          fatherNode.appendChild(element);
        }
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�õĸ��ڵ����һ���ӽڵ㡣
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeName �ӽڵ����ƣ���Vector������[�ӽڵ���1���ӽڵ���2]
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildNodes(String aFatherNodeName,int aFatherNodeIndex,
                                  Vector aNodeName) throws Exception
  {
    boolean retValue = false;
    if (aNodeName==null) return retValue;
    if (aFatherNodeName.equals("")||(aNodeName.size()==0)||(aFatherNodeIndex<0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<fatherNodeList.getLength())
      {
        Node fatherNode = fatherNodeList.item(aFatherNodeIndex);
        for(int i=0;i<aNodeName.size();i++)
        {
          Element element = doc.createElement((String)aNodeName.elementAt(i));
          fatherNode.appendChild(element);
        }
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò���һ�����ı��ӽڵ�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @return boolean �����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildTextNode(String aXmlFileName,boolean aIsParsingValid,
                                     String aFatherNodeName,int aFatherNodeIndex,
                                     String aNodeName,String aNodeValue) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||(aFatherNodeIndex<0)||aNodeName.equals("")||aNodeValue.equals(""))
      return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<fatherNodeList.getLength())
      {
        Node fatherNode = fatherNodeList.item(aFatherNodeIndex);
        Element element = doc.createElement(aNodeName);
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò���һ�����ı��ӽڵ�
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @return boolean �����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildTextNode(String aFatherNodeName,int aFatherNodeIndex,
                                     String aNodeName,String aNodeValue) throws Exception
  {
    boolean retValue = false;
    if (aFatherNodeName.equals("")||(aFatherNodeIndex<0)||aNodeName.equals("")||aNodeValue.equals(""))
      return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<fatherNodeList.getLength())
      {
        Node fatherNode = fatherNodeList.item(aFatherNodeIndex);
        Element element = doc.createElement(aNodeName);
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò���һ���µĴ����Ե��ı��ӽڵ�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean �����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildTextNode(String aXmlFileName,boolean aIsParsingValid,
                                     String aFatherNodeName,int aFatherNodeIndex,
                                     String aNodeName,String aNodeValue,
                                     Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aAttributesNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||(aFatherNodeIndex<0)||aNodeName.equals("")||aNodeValue.equals("")
        ||(aAttributesNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<fatherNodeList.getLength())
      {
        Node fatherNode = fatherNodeList.item(aFatherNodeIndex);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò���һ���µĴ����Ե��ı��ӽڵ�
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeName �ı��ӽڵ�����
   * @param aNodeValue �ı�ֵ
   * @param aAttributesNameValue [[������������ֵ]��[������������ֵ]]
   * @return boolean �����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildTextNode(String aFatherNodeName,int aFatherNodeIndex,
                                     String aNodeName,String aNodeValue,
                                     Vector aAttributesNameValue) throws Exception
  {
    boolean retValue = false;
    if (aAttributesNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||(aFatherNodeIndex<0)||aNodeName.equals("")||aNodeValue.equals("")
        ||(aAttributesNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<fatherNodeList.getLength())
      {
        Node fatherNode = fatherNodeList.item(aFatherNodeIndex);
        Element element = doc.createElement(aNodeName);
        for(int i=0;i<aAttributesNameValue.size();i++)
          element.setAttribute((String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(0),
                               (String)((Vector) aAttributesNameValue.elementAt(i)).elementAt(1));
        Text text = doc.createTextNode(aNodeName);
        text.setData(aNodeValue);
        element.appendChild(text);
        fatherNode.appendChild(element);
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò���һ�����ı��ڵ�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeNameValue [[�ı��ڵ��ǣ��ı�]��[�ı��ڵ��ǣ��ı�]]
   * @return boolean �����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildTextNodes(String aXmlFileName,boolean aIsParsingValid,
                                      String aFatherNodeName,int aFatherNodeIndex,
                                      Vector aNodeNameValue) throws Exception
  {
    boolean retValue = false;
    if (aNodeNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||(aFatherNodeIndex<0)||(aNodeNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<fatherNodeList.getLength())
      {
        Node fatherNode = fatherNodeList.item(aFatherNodeIndex);
        for(int i=0;i<aNodeNameValue.size();i++)
        {
          Element element = doc.createElement((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(0));
          Text text = doc.createTextNode((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(0));
          text.setData((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(1));
          element.appendChild(text);
          fatherNode.appendChild(element);
        }
        if(saveDocument(aXmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ��ָ��λ�ò���һ�����ı��ڵ�
   * @param aFatherNodeName ���ڵ�����
   * @param aFatherNodeIndex ���ڵ�λ��
   * @param aNodeNameValue [[�ı��ڵ��ǣ��ı�]��[�ı��ڵ��ǣ��ı�]]
   * @return boolean �����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean insertChildTextNodes(String aFatherNodeName,int aFatherNodeIndex,
                                      Vector aNodeNameValue) throws Exception
  {
    boolean retValue = false;
    if (aNodeNameValue==null) return retValue;
    if (aFatherNodeName.equals("")||(aFatherNodeIndex<0)||(aNodeNameValue.size()==0)) return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList fatherNodeList = doc.getElementsByTagName(aFatherNodeName);
      if (aFatherNodeIndex<fatherNodeList.getLength())
      {
        Node fatherNode = fatherNodeList.item(aFatherNodeIndex);
        for(int i=0;i<aNodeNameValue.size();i++)
        {
          Element element = doc.createElement((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(0));
          Text text = doc.createTextNode((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(0));
          text.setData((String)((Vector)aNodeNameValue.elementAt(i)).elementAt(1));
          element.appendChild(text);
          fatherNode.appendChild(element);
        }
        if(saveDocument(this.xmlFileName,doc))
          retValue = true;
        else
          retValue = false;
      }
      else
        retValue = false;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /*�滻�м�ڵ�󣬸ýڵ����������ڵ㶼��ȥ�����ú�������û��ʵ�ʵ���Ҫ*/
  private boolean replaceChildNode(String aOldNodeName,int aOldNodeIndex,
                                   String aNewNodeName) throws Exception
  {
    boolean retValue = false;
    if(aOldNodeName.equals("")||(aOldNodeIndex<0)||aNewNodeName.equals(""))
      return retValue;
    try
    {
      Document doc = this.getParsingDocument(this.xmlFileName,this.isParsingValid);
      if (doc.getDocumentElement().getTagName().equals(aOldNodeName))
        return retValue;
      else
      {
        NodeList nodeList = doc.getElementsByTagName(aOldNodeName);
        if (aOldNodeIndex<nodeList.getLength())
        {
          Node oldNode = nodeList.item(aOldNodeIndex);
          Element element = doc.createElement(aNewNodeName);
          oldNode.getParentNode().replaceChild(element,oldNode);
          if(saveDocument(this.xmlFileName,doc))
            retValue = true;
          else
            retValue = false;
        }
        else
          retValue = false;
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ���Ľڵ������ֵ
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aAttributesName ��������
   * @param aAttributesValue Ҫ�޸ĵ�����Ŀ��ֵ
   * @return boolean �޸��Ƿ�ɹ�
   * @throws Exception
   */
  public boolean replaceNodeAttributes(String aXmlFileName,boolean aIsParsingValid,
                                       String aNodeName,int aNodeIndex,
                                       String aAttributesName,String aAttributesValue) throws Exception
  {
    boolean retValue = false;
    boolean change = false;
    if (aNodeName.equals("")||(aNodeIndex<0)||aAttributesName.equals("")) return retValue;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        if (attributes.getLength()==0)
          return retValue;
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
          {
            if (childNode.getNodeName().equals(aAttributesName))
            {
              childNode.setNodeValue(aAttributesValue);
              if(saveDocument(aXmlFileName,doc))
                change = true;
              break;
            }
          }
        }
        if (change)
          retValue = true;
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ���Ľڵ������ֵ
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aAttributesName ��������
   * @param aAttributesValue Ҫ�޸ĵ�����Ŀ��ֵ
   * @return boolean �޸��Ƿ�ɹ�
   * @throws Exception
   */
  public boolean replaceNodeAttributes(String aNodeName,int aNodeIndex,
                                       String aAttributesName,String aAttributesValue) throws Exception
  {
    boolean retValue = false;
    boolean change = false;
    if (aNodeName.equals("")||(aNodeIndex<0)||aAttributesName.equals("")) return retValue;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        if (attributes.getLength()==0)
          return retValue;
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
          {
            if (childNode.getNodeName().equals(aAttributesName))
            {
              childNode.setNodeValue(aAttributesValue);
              if(saveDocument(this.xmlFileName,doc))
                change = true;
              break;
            }
          }
        }
        if (change)
          retValue = true;
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * �����ı��ڵ���ı������ԭ�ı�Ϊ�գ�������ı���ͬʱ��������ı���
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aTextNodeText Ҫ�޸ĵ�Ŀ���ı�ֵ
   * @return boolean �޸��Ƿ�ɹ�
   * @throws Exception
   */
  public boolean replaceTextNodeText(String aXmlFileName,boolean aIsParsingValid,
                                     String aNodeName,int aNodeIndex,String aTextNodeText) throws Exception
  {
    boolean retValue = false;
    boolean change=false;
    if (aNodeName.equals("")||(aNodeIndex<0)) return retValue;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if(node.getChildNodes().item(i).getNodeType()!=Node.TEXT_NODE)
              continue;
            else
            {
              node.getChildNodes().item(i).setNodeValue(aTextNodeText);
              if(saveDocument(aXmlFileName,doc))
                change = true;
            }
          }
        }
        else
        {
          Text text = doc.createTextNode(aTextNodeText);
          text.setData(aTextNodeText);
          node.appendChild(text);
          if(saveDocument(aXmlFileName,doc))
            change = true;
        }
      }
      if (change) retValue=true;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * �����ı��ڵ���ı������ԭ�ı�Ϊ�գ�������ı���ͬʱ��������ı���
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aTextNodeText Ҫ�޸ĵ�Ŀ���ı�ֵ
   * @return boolean �޸��Ƿ�ɹ�
   * @throws Exception
   */
  public boolean replaceTextNodeText(String aNodeName,int aNodeIndex,String aTextNodeText) throws Exception
  {
    boolean retValue = false;
    boolean change=false;
    if (aNodeName.equals("")||(aNodeIndex<0)) return retValue;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if(node.getChildNodes().item(i).getNodeType()!=Node.TEXT_NODE)
              continue;
            else
            {
              node.getChildNodes().item(i).setNodeValue(aTextNodeText);
              if(saveDocument(this.xmlFileName,doc))
                change = true;
            }
          }
        }
        else
        {
          Text text = doc.createTextNode(aTextNodeText);
          text.setData(aTextNodeText);
          node.appendChild(text);
          if(saveDocument(this.xmlFileName,doc))
            change = true;
        }
      }
      if (change) retValue=true;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /*----------------------------xmlDelete----------------------------*/
  /**
   * ����ı��ڵ���ı�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean clearTextNodeText(String aXmlFileName,boolean aIsParsingValid,
                                   String aNodeName,int aNodeIndex) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)) return retValue;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if(node.getChildNodes().item(i).getNodeType()!=Node.TEXT_NODE)
              continue;
            else
            {
              node.removeChild(node.getChildNodes().item(i));
              if(saveDocument(aXmlFileName,doc))
                retValue = true;
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ����ı��ڵ���ı�
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean clearTextNodeText(String aNodeName,int aNodeIndex) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)) return retValue;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if(node.getChildNodes().item(i).getNodeType()!=Node.TEXT_NODE)
              continue;
            else
            {
              node.removeChild(node.getChildNodes().item(i));
              if(saveDocument(this.xmlFileName,doc))
                retValue = true;
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ���ָ���ڵ��ָ������ֵ
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aAttributesName ��������
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean clearNodeAttribute(String aXmlFileName,boolean aIsParsingValid,
                                    String aNodeName,int aNodeIndex,
                                    String aAttributesName) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)||aAttributesName.equals("")) return retValue;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        if (attributes.getLength()==0)
          return retValue;
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
          {
            if (childNode.getNodeName().equals(aAttributesName))
            {
              childNode.setNodeValue("");
              if(saveDocument(aXmlFileName,doc))
                retValue=true;
              break;
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ���ָ���ڵ��ָ������ֵ
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aAttributesName ��������
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean clearNodeAttribute(String aNodeName,int aNodeIndex,
                                    String aAttributesName) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)||aAttributesName.equals("")) return retValue;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        if (attributes.getLength()==0)
          return retValue;
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
          {
            if (childNode.getNodeName().equals(aAttributesName))
            {
              childNode.setNodeValue("");
              if(saveDocument(this.xmlFileName,doc))
                retValue=true;
              break;
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ���ָ���ڵ����������ֵ
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean clearAllNodeAttributes(String aXmlFileName,boolean aIsParsingValid,
                                        String aNodeName,int aNodeIndex) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)) return retValue;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        if (attributes.getLength()==0)
          return retValue;
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
          {
            if (!childNode.getNodeName().equals(""))
            {
              childNode.setNodeValue("");
            }
          }
        }
        if(saveDocument(aXmlFileName,doc))
          retValue=true;
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ���ָ���ڵ����������ֵ
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean clearAllNodeAttributes(String aNodeName,int aNodeIndex) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)) return retValue;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        NamedNodeMap attributes = node.getAttributes();
        if (attributes.getLength()==0)
          return retValue;
        for(int i=0;i<attributes.getLength();i++)
        {
          Node childNode = attributes.item(i);
          if ((childNode.getNodeType()==Node.ATTRIBUTE_NODE))
          {
            if (!childNode.getNodeName().equals(""))
            {
              childNode.setNodeValue("");
            }
          }
        }
        if(saveDocument(this.xmlFileName,doc))
          retValue=true;
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ���Xml�ĵ����������ݣ�ֻ������Ԫ�ؼ���Ԫ�ص�����
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean clearXmlFile(String aXmlFileName,boolean aIsParsingValid) throws Exception
  {
    boolean retValue = false;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      Element rootElement = doc.getDocumentElement();
      Node node = rootElement.cloneNode(false);
      doc.replaceChild(node,rootElement);
      if(saveDocument(aXmlFileName,doc))
        retValue=true;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ���Xml�ĵ����������ݣ�ֻ������Ԫ�ؼ���Ԫ�ص�����
   * @return boolean ����Ƿ�ɹ�
   * @throws Exception
   */
  public boolean clearXmlFile() throws Exception
  {
    boolean retValue = false;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      Element rootElement = doc.getDocumentElement();
      Node node = rootElement.cloneNode(false);
      doc.replaceChild(node,rootElement);
      if(saveDocument(this.xmlFileName,doc))
        retValue=true;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ����Xml�ĵ�
   * @param aXmlFileName XML�ļ���
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteXmlFile(String aXmlFileName) throws Exception
  {
    boolean retValue = false;
    try
    {
      java.io.File file = new File(aXmlFileName);
      if (file.exists())
        if(file.delete())
          return retValue;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ����Xml�ĵ�
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteXmlFile() throws Exception
  {
    boolean retValue = false;
    try
    {
      java.io.File file = new File(this.xmlFileName);
      if (file.exists())
        if(file.delete())
          return retValue;
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ��λ�õĽڵ�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteNode(String aXmlFileName,boolean aIsParsingValid,
                            String aNodeName,int aNodeIndex) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)) return retValue;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      Element rootElement = doc.getDocumentElement();
      if (rootElement.getNodeName().equals(aNodeName)) return retValue;
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        node.getParentNode().removeChild(node);
        if(saveDocument(aXmlFileName,doc))
          retValue=true;
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ��λ�õĽڵ�
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteNode(String aNodeName,int aNodeIndex) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)) return retValue;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      Element rootElement = doc.getDocumentElement();
      if (rootElement.getNodeName().equals(aNodeName)) return retValue;
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        node.getParentNode().removeChild(node);
        if(saveDocument(this.xmlFileName,doc))
          retValue=true;
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ���ڵ��ָ���ӽڵ�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aChildNodeName �ӽڵ���
   * @param aChildNodeIndex �ӽڵ��ڸ��ڵ���������λ��
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteChildNode(String aXmlFileName,boolean aIsParsingValid,
                                 String aNodeName,int aNodeIndex,
                                 String aChildNodeName,int aChildNodeIndex) throws Exception
  {
    boolean retValue = false;
    int flag=0;
    if (aNodeName.equals("")||(aNodeIndex<0)||aChildNodeName.equals("")||(aChildNodeIndex<0))
      return retValue;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if (node.getChildNodes().item(i).getNodeType()!=Node.ELEMENT_NODE) continue;
            if (node.getChildNodes().item(i).getNodeName().equals(aChildNodeName))
            {
              if (aChildNodeIndex==flag)
              {
                node.removeChild(node.getChildNodes().item(i));
                if(saveDocument(aXmlFileName,doc))
                  retValue = true;
              }
              else
                flag++;
            }
          }
        }
      }
    }
    catch (Exception e)
    {
//      retValue = false;
//      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ���ڵ��ָ���ӽڵ�
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aChildNodeName �ӽڵ���
   * @param aChildNodeIndex �ӽڵ��ڸ��ڵ���������λ��
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteChildNode(String aNodeName,int aNodeIndex,
                                 String aChildNodeName,int aChildNodeIndex) throws Exception
  {
    boolean retValue = false;
    int flag=0;
    if (aNodeName.equals("")||(aNodeIndex<0)||aChildNodeName.equals("")||(aChildNodeIndex<0))
      return retValue;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if (node.getChildNodes().item(i).getNodeType()!=Node.ELEMENT_NODE) continue;
            if (node.getChildNodes().item(i).getNodeName().equals(aChildNodeName))
            {
              if (aChildNodeIndex==flag)
              {
                node.removeChild(node.getChildNodes().item(i));
                if(saveDocument(this.xmlFileName,doc))
                  retValue = true;
              }
              else
                flag++;
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ���ڵ������ͬһ���Ƶ��ӽڵ�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aChildNodeName �ӽڵ���
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteChildNode(String aXmlFileName,boolean aIsParsingValid,
                                 String aNodeName,int aNodeIndex,
                                 String aChildNodeName) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)||aChildNodeName.equals(""))
      return retValue;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if (node.getChildNodes().item(i).getNodeType()!=Node.ELEMENT_NODE) continue;
            if (node.getChildNodes().item(i).getNodeName().equals(aChildNodeName))
                node.removeChild(node.getChildNodes().item(i));
          }
          if(saveDocument(aXmlFileName,doc))
            retValue = true;
        }
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ���ڵ������ͬһ���Ƶ��ӽڵ�
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @param aChildNodeName �ӽڵ���
   * @param aChildNodeIndex �ӽڵ��ڸ��ڵ���������λ��
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteChildNode(String aNodeName,int aNodeIndex,
                                 String aChildNodeName) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0)||aChildNodeName.equals(""))
      return retValue;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
        Node node = list.item(aNodeIndex);
        if (node.hasChildNodes())
        {
          for(int i=0;i<node.getChildNodes().getLength();i++)
          {
            if (node.getChildNodes().item(i).getNodeType()!=Node.ELEMENT_NODE) continue;
            if (node.getChildNodes().item(i).getNodeName().equals(aChildNodeName))
                node.removeChild(node.getChildNodes().item(i));
          }
          if(saveDocument(this.xmlFileName,doc))
            retValue = true;
        }
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ���ڵ�������ӽڵ�
   * @param aXmlFileName XML�ļ���
   * @param aIsParsingValid �Ƿ����dtd��Ч�Լ��
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteAllChildNodes(String aXmlFileName,boolean aIsParsingValid,
                                     String aNodeName,int aNodeIndex) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0))
      return retValue;
    try
    {
      Document doc = getParsingDocument(aXmlFileName,aIsParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
          Node node = list.item(aNodeIndex);
          Node newNode = node.cloneNode(false);
          node.getParentNode().replaceChild(newNode,node);
          if(saveDocument(aXmlFileName,doc))
            retValue = true;
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

  /**
   * ɾ��ָ���ڵ�������ӽڵ�
   * @param aNodeName �ڵ���
   * @param aNodeIndex �ڵ����ĵ���������λ��
   * @return boolean ɾ���Ƿ�ɹ�
   * @throws Exception
   */
  public boolean deleteAllChildNodes(String aNodeName,int aNodeIndex) throws Exception
  {
    boolean retValue = false;
    if (aNodeName.equals("")||(aNodeIndex<0))
      return retValue;
    try
    {
      Document doc = getParsingDocument(this.xmlFileName,this.isParsingValid);
      NodeList list = doc.getElementsByTagName(aNodeName);
      if (aNodeIndex<(list.getLength()))
      {
          Node node = list.item(aNodeIndex);
          Node newNode = node.cloneNode(false);
          node.getParentNode().replaceChild(newNode,node);
          if(saveDocument(this.xmlFileName,doc))
            retValue = true;
      }
    }
    catch (Exception e)
    {
      retValue = false;
      throw e;
    }
    return retValue;
  }

}