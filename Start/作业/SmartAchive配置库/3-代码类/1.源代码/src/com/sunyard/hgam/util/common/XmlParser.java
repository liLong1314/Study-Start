package com.sunyard.hgam.util.common ;

/**
 * <p>Title: DOM分析器封装类</p>
 * <p>Description: 对DOM分析器的一些功能进行封装</p>
 * <p>Copyright: Copyright (c) 2003.5.15</p>
 * <p>Company: 杭州信雅达系统工程股份有限公司</p>
 * @author 许朝锋
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
  //XML文件名
  protected String xmlFileName;
  //是否进行DTD有效性检测
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
   * 生成新的doc对象
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
   * 根据文件获取文档对象
   * @param aXmlFileName XML文件名
   * @param aIsparsingValid 是否进行dtd有效性检测
   * @return Document 文档对象
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
   * 获取节点的所有子节点名称
   * @param node 传入节点
   * @return Vector 子节点名称
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
   * 获取子节点的节点名，如果有相同的节点名，只取一个。
   * @param node 传入节点
   * @return Vector 唯一的子节点名称
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
   * 获取子文本节点的节点名和节点文本值。如文件如下：
   * <FatherNode>
   *   <ChildNode1>Value1</ChildNode1>
   *   <ChildNode2>Value2</ChildNode2>
   * </FatherNode>
   * 调用getChildTextNodeText(node,1)，返回：[ChildNode2,Value2]
   * @param aFatherNode 父节点
   * @param aChildNodeIndex 子节点在父节点所处位置
   * @return Vector 子节点名及值，形如[节点名，文本值]
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
   * 过滤空字符串
   * @param aString 输入字符串
   * @return String 非null的字符串，如果是null，返回""
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
   * 过滤空数值
   * @param aInteger 输入数值
   * @return Integer 非null的数值，如果是null，返回Integer类型的0
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
   * 根据文件名，文件头信息创建新XML文档
   * @param aXmlFileName XML文件名
   * @param aFileHead XML文件头
   * @param aDtdInformation 是否有效性检测必须的DTD关联语句
   * @param aRootElementName 文档根元素名称。
   * @return 创建是否成功
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
   * 根据文件名，文件头信息创建新XML文档
   * @param aXmlFileName XML文件名
   * @param aFileHead XML文件头
   * @param aDtdInformation 是否有效性检测必须的DTD关联语句
   * @param aRootElementName 文档根元素名称。
   * @return 创建是否成功
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
   * 根据已有XML文件复制一份新的XML文件
   * @param aOldXmlFileName 原有XML文件名（含全路径）
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNewXmlFileName 新XML文件名（含全路径）
   * @return boolean 复制是否成功
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
   * 获取某一名称的节点在该文档中的个数
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @return int 节点个数
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
   * 获取某一名称的节点在该文档中的个数
   * @param aNodeName 节点名
   * @return int 节点个数
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
   * 获取某一名称的节点在该文档中的个数
   * @param aNodeName 节点名
   * @return int 节点个数
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
   * 获取正在分析的文档的根节点名称
   * @return String 根节点名称
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
   * 获取要分析的XML文档的根节点名称
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @return String 根节点名称
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
   * 获取XML文档中指定位置和节点名的节点的属性名和属性值
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return Vector 形为[[属性名，属性值]，[属性名，属性值]，[属性名，属性值]]
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
   * 获取XML文档中指定位置和节点名的节点的属性名和属性值
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return Vector 形为[[属性名，属性值]，[属性名，属性值]，[属性名，属性值]]
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
   * 获取根据文本节点名及及文本节点的文本值获取所有符合条件的节点属性，文档如下：
   * <QUERY>
   *   <node 属性名1="属性值1" 属性名2="属性值2">value</node>
   *   <node 属性名1="属性值3" 属性名2="属性值4">value</node>
   * </QUERY>
   * 输入参数：aNodeName="node",aNodeText="value"
   * 返回：{序号1=[[属性名1,属性值3],[属性名2,属性值4]],序号0=[[属性名1,属性值1],[属性名2,属性值2]]}
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeText 文本节点的文本值
   * @return Hashtable 形为{序号1=[[属性名,属性值],[属性名,属性值]],
   *                        序号0=[[属性名,属性值],[属性名,属性值]]}
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
   * 获取根据文本节点名及及文本节点的文本值获取所有符合条件的节点属性，文档如下：
   * <QUERY>
   *   <node 属性名1="属性值1" 属性名2="属性值2">value</node>
   *   <node 属性名1="属性值3" 属性名2="属性值4">value</node>
   * </QUERY>
   * 输入参数：aNodeName="node",aNodeText="value"
   * 返回：{序号1=[[属性名1,属性值3],[属性名2,属性值4]],序号0=[[属性名1,属性值1],[属性名2,属性值2]]}
   * @param aNodeName 节点名
   * @param aNodeText 文本节点的文本值
   * @return Hashtable 形为{序号1=[[属性名,属性值],[属性名,属性值]],
   *                        序号0=[[属性名,属性值],[属性名,属性值]]}
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
   * 取得所有子节点的属性，如文档如下：
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
   * 参数分别为：文件名，false或true，SELECT，0
   * 返回结果：{2=[[name, SourceTable3]], 1=[[name, SourceTable2]], 0=[[name, SourceTable1], [value, asdf]]}
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return Hashtable 形为 {节点位置=[[属性名,属性值]，[属性名,属性值]],节点位置=[[属性名,属性值]，[属性名,属性值]]}
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
   * 取得所有子节点的属性，如文档如下：
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
   * 参数分别为：文件名，false或true，SELECT，0
   * 返回结果：{2=[[name, SourceTable3]], 1=[[name, SourceTable2]], 0=[[name, SourceTable1], [value, asdf]]}
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return Hashtable 形为 {节点位置=[[属性名,属性值]，[属性名,属性值]],节点位置=[[属性名,属性值]，[属性名,属性值]]}
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
   * 根据指定节点获取该节点指定属性名的属性值
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aAttributeName 属性名
   * @return String 属性值
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
   * 根据指定节点获取该节点指定属性名的属性值
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aAttributeName 属性名
   * @return String 属性值
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
   * 获取XML文档中对应节点的文本，如<Test>aaa</Test>则aNodeName为Test,
   * aNodeIndex指这个节点在文档中所处的位置
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处位置
   * @return String 该节点内的文本内容
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
   * 获取XML文档中对应节点的文本，如<Test>aaa</Test>则aNodeName为Test,
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处位置
   * @return String 该节点内的文本内容
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
   * 获取XML文档中的对应指定位置节点下所有子节点的名称
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 第几个父节点
   * @return 该节点下所有的子节点名称
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
   * 获取XML文档中的对应指定位置节点下所有子节点的名称
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 第几个父节点
   * @return 该节点下所有的子节点名称
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
   * 获取XML文档中的对应指定位置节点下所有子节点的名称，名称只取唯一值
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 第几个父节点
   * @return 该节点下所有的子节点名称，该名称是唯一的。
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
   * 获取XML文档中的对应指定位置节点下所有子节点的名称，名称只取唯一值
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 第几个父节点
   * @return 该节点下所有的子节点名称，该名称是唯一的。
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
   * 获取所有子文本节点的节点名和节点值。如文件如下：
   * <FatherNode/>
   * <FatherNode>
   *   <ChildNode1>Value1</ChildNode1>
   *   <ChildNode2>Value2</ChildNode2>
   * </FatherNode>
   * 调用getAllChildTextNodesText(FatherNode,1)，返回：[[ChildNode1,Value1],[ChildNode2,Value2]]
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名
   * @param aFatherNodeIndex 父节点在文档中所处的位置
   * @return Vector 形如[[节点名，文本值]，[节点名，文本值]，[节点名，文本值]]
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
   * 获取所有子文本节点的节点名和节点值。如文件如下：
   * <FatherNode/>
   * <FatherNode>
   *   <ChildNode1>Value1</ChildNode1>
   *   <ChildNode2>Value2</ChildNode2>
   * </FatherNode>
   * 调用getAllChildTextNodesText(FatherNode,1)，返回：[[ChildNode1,Value1],[ChildNode2,Value2]]
   * @param aFatherNodeName 父节点名
   * @param aFatherNodeIndex 父节点在文档中所处的位置
   * @return Vector 形如[[节点名，文本值]，[节点名，文本值]，[节点名，文本值]]
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
   * 在指定的最后一个父节点添加一个子节点。
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 子节点名称
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 子节点名称
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 子节点名称
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个带属性的子节点。
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 子节点名称
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个带属性的子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 子节点名称
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个带属性的子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 子节点名称
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一组子节点。
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 子节点名称，用Vector保存如[子节点名1，子节点名2]
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一组子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 子节点名称，用Vector保存如[子节点名1，子节点名2]
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个文本子节点。
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个文本子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个文本子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个文本子节点。
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aNodeNameValue [[文本节点标记，文本]，[文本节点标记，文本]]
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个文本子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeNameValue [[文本节点标记，文本]，[文本节点标记，文本]]
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个带属性的文本子节点。
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个带属性的文本子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 添加是否成功
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
   * 在指定的最后一个父节点添加一个带属性的文本子节点。
   * @param aFatherNodeName 父节点名称
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 添加是否成功
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
   * 对指定位置的节点添加属性，如果属性存在则改变属性值
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 添加是否成功
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
   * 对指定位置的节点添加属性，如果属性存在则改变属性值
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 添加是否成功
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
   * 对指定位置的文本节点添加文本，如果有文本存在，则追加在末尾
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aNodeText 要添加的文本
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
   * 对指定位置的文本节点添加文本，如果有文本存在，则追加在末尾
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aNodeText 要添加的文本
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
   * 在指定位置插入新子节点
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeName 子节点名称
   * @return boolean 插入子节点是否成功
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
   * 在指定位置插入新子节点
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeName 子节点名称
   * @return boolean 插入子节点是否成功
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
   * 在指定位置插入带属性的新子节点
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeName 子节点名称
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 插入子节点是否成功
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
   * 在指定位置插入带属性的新子节点
   * @param aFatherNodeName 父节点名称
   * @param aNodeIndex 父节点位置
   * @param aNodeName 子节点名称
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 插入子节点是否成功
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
   * 给指定位置的父节点添加一组子节点。
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeName 子节点名称，用Vector保存如[子节点名1，子节点名2]
   * @return boolean 添加是否成功
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
   * 给指定位置的父节点添加一组子节点。
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeName 子节点名称，用Vector保存如[子节点名1，子节点名2]
   * @return boolean 添加是否成功
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
   * 在指定位置插入一个新文本子节点
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @return boolean 插入是否成功
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
   * 在指定位置插入一个新文本子节点
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @return boolean 插入是否成功
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
   * 在指定位置插入一个新的带属性的文本子节点
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 插入是否成功
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
   * 在指定位置插入一个新的带属性的文本子节点
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeName 文本子节点名称
   * @param aNodeValue 文本值
   * @param aAttributesNameValue [[属性名，属性值]，[属性名，属性值]]
   * @return boolean 插入是否成功
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
   * 在指定位置插入一组新文本节点
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeNameValue [[文本节点标记，文本]，[文本节点标记，文本]]
   * @return boolean 插入是否成功
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
   * 在指定位置插入一组新文本节点
   * @param aFatherNodeName 父节点名称
   * @param aFatherNodeIndex 父节点位置
   * @param aNodeNameValue [[文本节点标记，文本]，[文本节点标记，文本]]
   * @return boolean 插入是否成功
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

  /*替换中间节点后，该节点的所有子孙节点都被去除，该函数可能没有实际的需要*/
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
   * 更改节点的属性值
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aAttributesName 属性名称
   * @param aAttributesValue 要修改的属性目标值
   * @return boolean 修改是否成功
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
   * 更改节点的属性值
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aAttributesName 属性名称
   * @param aAttributesValue 要修改的属性目标值
   * @return boolean 修改是否成功
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
   * 更改文本节点的文本，如果原文本为空，则添加文本，同时可以清空文本。
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aTextNodeText 要修改的目标文本值
   * @return boolean 修改是否成功
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
   * 更改文本节点的文本，如果原文本为空，则添加文本，同时可以清空文本。
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aTextNodeText 要修改的目标文本值
   * @return boolean 修改是否成功
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
   * 清除文本节点的文本
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return boolean 清除是否成功
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
   * 清除文本节点的文本
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return boolean 清除是否成功
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
   * 清除指定节点的指定属性值
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aAttributesName 属性名称
   * @return boolean 清除是否成功
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
   * 清除指定节点的指定属性值
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aAttributesName 属性名称
   * @return boolean 清除是否成功
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
   * 清除指定节点的所有属性值
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return boolean 清除是否成功
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
   * 清除指定节点的所有属性值
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return boolean 清除是否成功
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
   * 清空Xml文档的所有内容，只保留根元素及根元素的属性
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @return boolean 清空是否成功
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
   * 清空Xml文档的所有内容，只保留根元素及根元素的属性
   * @return boolean 清空是否成功
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
   * 删除指定的Xml文档
   * @param aXmlFileName XML文件名
   * @return boolean 删除是否成功
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
   * 删除指定的Xml文档
   * @return boolean 删除是否成功
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
   * 删除指定位置的节点
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return boolean 删除是否成功
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
   * 删除指定位置的节点
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return boolean 删除是否成功
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
   * 删除指定节点的指定子节点
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aChildNodeName 子节点名
   * @param aChildNodeIndex 子节点在父节点中所处的位置
   * @return boolean 删除是否成功
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
   * 删除指定节点的指定子节点
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aChildNodeName 子节点名
   * @param aChildNodeIndex 子节点在父节点中所处的位置
   * @return boolean 删除是否成功
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
   * 删除指定节点的所有同一名称的子节点
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aChildNodeName 子节点名
   * @return boolean 删除是否成功
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
   * 删除指定节点的所有同一名称的子节点
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @param aChildNodeName 子节点名
   * @param aChildNodeIndex 子节点在父节点中所处的位置
   * @return boolean 删除是否成功
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
   * 删除指定节点的所有子节点
   * @param aXmlFileName XML文件名
   * @param aIsParsingValid 是否进行dtd有效性检测
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return boolean 删除是否成功
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
   * 删除指定节点的所有子节点
   * @param aNodeName 节点名
   * @param aNodeIndex 节点在文档中所处的位置
   * @return boolean 删除是否成功
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