package com.sunyard.hgam.persistence.dao.beans.adc;

import java.io.*;

/**
 * <p>Title: HGAM</p>
 * <p>Description: 杭州市规划档案综合管理系统</p>
 * <p>Copyright: Copyright (c) 2003 </p>
 * <p>Company: Sunhoo Co.,Ltd.</p>
 * @author 郑先全
 * @version 1.0
 */

public class Archives implements Serializable {
  private Integer aARCHIVES_ID;
  private String aENTRY_ID;
  private String aCONTAINER_ID;
  private String aREF_ARCHIVES_ID;
  private String aFONDS_NUM;
  private String aCATALOG_NUM;
  private String aROLL_NUM;
  private String aPIECE_NUM;
  private String aARCHIVES_NUM;
  private String aARC_NUM;
  private String aARCHIVES_ROOM_CODE;
  private String aROLL_MODE;
  private String aMAKE_DATE;
  private String aMAKE_MAN;
  private String aREDUCE_NUM;
  private String aITEM_NUM;
  private String aREG_NUM;
  private String aARCHIVES_STATUS;
  private String aARCHIVES_TYPE;
  private String aARCHIVES_CONTENT;
  private String aARCHIVES_YEAR;
  private String aARCHIVES_NAME;
  private String aPROJ_ID;
  private String aPROJ_NAME;
  private String aBEGIN_DATE;
  private String aEND_DATE;
  private String aORGAN;
  private String aSTORE_TERM;
  private String aARCHIVES_FOUND_DATE;
  private String aARCHIVES_FOUND_UNIT;
  private String aARCHIVES_FOUND_MAN;
  private String aARCHIVES_MAKE_PERIOD;
  private String aARCHIVES_UNIT;
  private String aPAGE_AMOUNT;
  private String aROLL_AMOUNT;
  private String aROLL_SEQ;
  private String aMEDIA_TYPE;
  private String aPHOTO_NUM;
  private String aNEGATIVE_NUM;
  private String aIS_BORROW;
  private String aIS_CHANGE;
  private String aIS_PRIVATE;
  private String aIS_OPERATION;
  private String aOPER_ID;
  private String aREMARK;
  private String aARCHIVES_AMOUNT;
  private String aSPECIFICATION;
  private String aPAGE_NUM_FROM_TO;
  private String aIS_EXIST_ARCHIVES_NUM;
  private String aARC_DATE;
  private String aARC_PIECE_NUM;
  private String aIS_EXIST_ROLL_NUM;
  private String aIS_EXIST_PIECE_NUM;
  private String aSECRET_ID;
  private String aARCHIVES_MAKE_UNIT;

  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }
  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public Integer getAARCHIVES_ID() {
    return aARCHIVES_ID;
  }
  public void setAARCHIVES_ID(Integer aARCHIVES_ID) {
    this.aARCHIVES_ID = aARCHIVES_ID;
  }
  public String getAENTRY_ID() {
    return aENTRY_ID;
  }
  public void setAENTRY_ID(String aENTRY_ID) {
    this.aENTRY_ID = aENTRY_ID;
  }
  public String getACONTAINER_ID() {
    return aCONTAINER_ID;
  }
  public void setACONTAINER_ID(String aCONTAINER_ID) {
    this.aCONTAINER_ID = aCONTAINER_ID;
  }
  public String getAREF_ARCHIVES_ID() {
    return aREF_ARCHIVES_ID;
  }
  public void setAREF_ARCHIVES_ID(String aREF_ARCHIVES_ID) {
    this.aREF_ARCHIVES_ID = aREF_ARCHIVES_ID;
  }
  public String getAFONDS_NUM() {
    return aFONDS_NUM;
  }
  public void setAFONDS_NUM(String aFONDS_NUM) {
    this.aFONDS_NUM = aFONDS_NUM;
  }
  public String getACATALOG_NUM() {
    return aCATALOG_NUM;
  }
  public void setACATALOG_NUM(String aCATALOG_NUM) {
    this.aCATALOG_NUM = aCATALOG_NUM;
  }
  public String getAROLL_NUM() {
    return aROLL_NUM;
  }
  public void setAROLL_NUM(String aROLL_NUM) {
    this.aROLL_NUM = aROLL_NUM;
  }
  public String getAPIECE_NUM() {
    return aPIECE_NUM;
  }
  public void setAPIECE_NUM(String aPIECE_NUM) {
    this.aPIECE_NUM = aPIECE_NUM;
  }
  public String getAARCHIVES_NUM() {
    return aARCHIVES_NUM;
  }
  public void setAARCHIVES_NUM(String aARCHIVES_NUM) {
    this.aARCHIVES_NUM = aARCHIVES_NUM;
  }
  public String getAARC_NUM() {
    return aARC_NUM;
  }
  public void setAARC_NUM(String aARC_NUM) {
    this.aARC_NUM = aARC_NUM;
  }
  public String getAARCHIVES_ROOM_CODE() {
    return aARCHIVES_ROOM_CODE;
  }
  public void setAARCHIVES_ROOM_CODE(String aARCHIVES_ROOM_CODE) {
    this.aARCHIVES_ROOM_CODE = aARCHIVES_ROOM_CODE;
  }
  public String getAROLL_MODE() {
    return aROLL_MODE;
  }
  public void setAROLL_MODE(String aROLL_MODE) {
    this.aROLL_MODE = aROLL_MODE;
  }
  public String getAMAKE_DATE() {
    return aMAKE_DATE;
  }
  public void setAMAKE_DATE(String aMAKE_DATE) {
    this.aMAKE_DATE = aMAKE_DATE;
  }
  public String getAMAKE_MAN() {
    return aMAKE_MAN;
  }
  public void setAMAKE_MAN(String aMAKE_MAN) {
    this.aMAKE_MAN = aMAKE_MAN;
  }
  public String getAREDUCE_NUM() {
    return aREDUCE_NUM;
  }
  public void setAREDUCE_NUM(String aREDUCE_NUM) {
    this.aREDUCE_NUM = aREDUCE_NUM;
  }
  public String getAITEM_NUM() {
    return aITEM_NUM;
  }
  public void setAITEM_NUM(String aITEM_NUM) {
    this.aITEM_NUM = aITEM_NUM;
  }
  public String getAREG_NUM() {
    return aREG_NUM;
  }
  public void setAREG_NUM(String aREG_NUM) {
    this.aREG_NUM = aREG_NUM;
  }
  public String getAARCHIVES_STATUS() {
    return aARCHIVES_STATUS;
  }
  public void setAARCHIVES_STATUS(String aARCHIVES_STATUS) {
    this.aARCHIVES_STATUS = aARCHIVES_STATUS;
  }
  public String getAARCHIVES_TYPE() {
    return aARCHIVES_TYPE;
  }
  public void setAARCHIVES_TYPE(String aARCHIVES_TYPE) {
    this.aARCHIVES_TYPE = aARCHIVES_TYPE;
  }
  public String getAARCHIVES_CONTENT() {
    return aARCHIVES_CONTENT;
  }
  public void setAARCHIVES_CONTENT(String aARCHIVES_CONTENT) {
    this.aARCHIVES_CONTENT = aARCHIVES_CONTENT;
  }
  public String getAARCHIVES_YEAR() {
    return aARCHIVES_YEAR;
  }
  public void setAARCHIVES_YEAR(String aARCHIVES_YEAR) {
    this.aARCHIVES_YEAR = aARCHIVES_YEAR;
  }
  public String getAARCHIVES_NAME() {
    return aARCHIVES_NAME;
  }
  public void setAARCHIVES_NAME(String aARCHIVES_NAME) {
    this.aARCHIVES_NAME = aARCHIVES_NAME;
  }
  public String getAPROJ_ID() {
    return aPROJ_ID;
  }
  public void setAPROJ_ID(String aPROJ_ID) {
    this.aPROJ_ID = aPROJ_ID;
  }
  public String getAPROJ_NAME() {
    return aPROJ_NAME;
  }
  public void setAPROJ_NAME(String aPROJ_NAME) {
    this.aPROJ_NAME = aPROJ_NAME;
  }
  public String getABEGIN_DATE() {
    return aBEGIN_DATE;
  }
  public void setABEGIN_DATE(String aBEGIN_DATE) {
    this.aBEGIN_DATE = aBEGIN_DATE;
  }
  public String getAEND_DATE() {
    return aEND_DATE;
  }
  public void setAEND_DATE(String aEND_DATE) {
    this.aEND_DATE = aEND_DATE;
  }
  public String getAORGAN() {
    return aORGAN;
  }
  public void setAORGAN(String aORGAN) {
    this.aORGAN = aORGAN;
  }
  public String getASTORE_TERM() {
    return aSTORE_TERM;
  }
  public void setASTORE_TERM(String aSTORE_TERM) {
    this.aSTORE_TERM = aSTORE_TERM;
  }
  public String getAARCHIVES_FOUND_DATE() {
    return aARCHIVES_FOUND_DATE;
  }
  public void setAARCHIVES_FOUND_DATE(String aARCHIVES_FOUND_DATE) {
    this.aARCHIVES_FOUND_DATE = aARCHIVES_FOUND_DATE;
  }
  public String getAARCHIVES_FOUND_UNIT() {
    return aARCHIVES_FOUND_UNIT;
  }
  public void setAARCHIVES_FOUND_UNIT(String aARCHIVES_FOUND_UNIT) {
    this.aARCHIVES_FOUND_UNIT = aARCHIVES_FOUND_UNIT;
  }
  public String getAARCHIVES_FOUND_MAN() {
    return aARCHIVES_FOUND_MAN;
  }
  public void setAARCHIVES_FOUND_MAN(String aARCHIVES_FOUND_MAN) {
    this.aARCHIVES_FOUND_MAN = aARCHIVES_FOUND_MAN;
  }
  public String getAARCHIVES_MAKE_PERIOD() {
    return aARCHIVES_MAKE_PERIOD;
  }
  public void setAARCHIVES_MAKE_PERIOD(String aARCHIVES_MAKE_PERIOD) {
    this.aARCHIVES_MAKE_PERIOD = aARCHIVES_MAKE_PERIOD;
  }
  public String getAARCHIVES_UNIT() {
    return aARCHIVES_UNIT;
  }
  public void setAARCHIVES_UNIT(String aARCHIVES_UNIT) {
    this.aARCHIVES_UNIT = aARCHIVES_UNIT;
  }
  public String getAPAGE_AMOUNT() {
    return aPAGE_AMOUNT;
  }
  public void setAPAGE_AMOUNT(String aPAGE_AMOUNT) {
    this.aPAGE_AMOUNT = aPAGE_AMOUNT;
  }
  public String getAROLL_AMOUNT() {
    return aROLL_AMOUNT;
  }
  public void setAROLL_AMOUNT(String aROLL_AMOUNT) {
    this.aROLL_AMOUNT = aROLL_AMOUNT;
  }
  public String getAROLL_SEQ() {
    return aROLL_SEQ;
  }
  public void setAROLL_SEQ(String aROLL_SEQ) {
    this.aROLL_SEQ = aROLL_SEQ;
  }
  public String getAMEDIA_TYPE() {
    return aMEDIA_TYPE;
  }
  public void setAMEDIA_TYPE(String aMEDIA_TYPE) {
    this.aMEDIA_TYPE = aMEDIA_TYPE;
  }
  public String getAPHOTO_NUM() {
    return aPHOTO_NUM;
  }
  public void setAPHOTO_NUM(String aPHOTO_NUM) {
    this.aPHOTO_NUM = aPHOTO_NUM;
  }
  public String getANEGATIVE_NUM() {
    return aNEGATIVE_NUM;
  }
  public void setANEGATIVE_NUM(String aNEGATIVE_NUM) {
    this.aNEGATIVE_NUM = aNEGATIVE_NUM;
  }
  public String getAIS_BORROW() {
    return aIS_BORROW;
  }
  public void setAIS_BORROW(String aIS_BORROW) {
    this.aIS_BORROW = aIS_BORROW;
  }
  public String getAIS_CHANGE() {
    return aIS_CHANGE;
  }
  public void setAIS_CHANGE(String aIS_CHANGE) {
    this.aIS_CHANGE = aIS_CHANGE;
  }
  public String getAIS_PRIVATE() {
    return aIS_PRIVATE;
  }
  public void setAIS_PRIVATE(String aIS_PRIVATE) {
    this.aIS_PRIVATE = aIS_PRIVATE;
  }
  public String getAIS_OPERATION() {
    return aIS_OPERATION;
  }
  public void setAIS_OPERATION(String aIS_OPERATION) {
    this.aIS_OPERATION = aIS_OPERATION;
  }
  public String getAOPER_ID() {
    return aOPER_ID;
  }
  public void setAOPER_ID(String aOPER_ID) {
    this.aOPER_ID = aOPER_ID;
  }
  public String getAREMARK() {
    return aREMARK;
  }
  public void setAREMARK(String aREMARK) {
    this.aREMARK = aREMARK;
  }
  public String getAARCHIVES_AMOUNT() {
    return aARCHIVES_AMOUNT;
  }
  public void setAARCHIVES_AMOUNT(String aARCHIVES_AMOUNT) {
    this.aARCHIVES_AMOUNT = aARCHIVES_AMOUNT;
  }
  public String getASPECIFICATION() {
    return aSPECIFICATION;
  }
  public void setASPECIFICATION(String aSPECIFICATION) {
    this.aSPECIFICATION = aSPECIFICATION;
  }
  public String getAPAGE_NUM_FROM_TO() {
    return aPAGE_NUM_FROM_TO;
  }
  public void setAPAGE_NUM_FROM_TO(String aPAGE_NUM_FROM_TO) {
    this.aPAGE_NUM_FROM_TO = aPAGE_NUM_FROM_TO;
  }
  public String getAIS_EXIST_ARCHIVES_NUM() {
    return aIS_EXIST_ARCHIVES_NUM;
  }
  public void setAIS_EXIST_ARCHIVES_NUM(String aIS_EXIST_ARCHIVES_NUM) {
    this.aIS_EXIST_ARCHIVES_NUM = aIS_EXIST_ARCHIVES_NUM;
  }
  public String getAARC_DATE() {
    return aARC_DATE;
  }
  public void setAARC_DATE(String aARC_DATE) {
    this.aARC_DATE = aARC_DATE;
  }
  public String getAARC_PIECE_NUM() {
    return aARC_PIECE_NUM;
  }
  public void setAARC_PIECE_NUM(String aARC_PIECE_NUM) {
    this.aARC_PIECE_NUM = aARC_PIECE_NUM;
  }
  public String getAIS_EXIST_ROLL_NUM() {
    return aIS_EXIST_ROLL_NUM;
  }
  public void setAIS_EXIST_ROLL_NUM(String aIS_EXIST_ROLL_NUM) {
    this.aIS_EXIST_ROLL_NUM = aIS_EXIST_ROLL_NUM;
  }
  public String getAIS_EXIST_PIECE_NUM() {
    return aIS_EXIST_PIECE_NUM;
  }
  public void setAIS_EXIST_PIECE_NUM(String aIS_EXIST_PIECE_NUM) {
    this.aIS_EXIST_PIECE_NUM = aIS_EXIST_PIECE_NUM;
  }
  public String getASECRET_ID() {
    return aSECRET_ID;
  }
  public void setASECRET_ID(String aSECRET_ID) {
    this.aSECRET_ID = aSECRET_ID;
  }
  public String getAARCHIVES_MAKE_UNIT() {
    return aARCHIVES_MAKE_UNIT;
  }
  public void setAARCHIVES_MAKE_UNIT(String aARCHIVES_MAKE_UNIT) {
    this.aARCHIVES_MAKE_UNIT = aARCHIVES_MAKE_UNIT;
  }

}
