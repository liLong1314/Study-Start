package com.sunyard.hgam.presentation.base;

import com.sunyard.hgam.persistence.dao.beans.arm.*;
import java.util.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: sunhoo.com</p>
 * @author not attributable
 * @version 1.00
 */

public class SysParamReplacer {

  private static SysParamOper sysParamOper = SysParamOper.getInstance();
/**
  public static void archivesRoll(ArchivesRoll archivesRoll) {
    archivesRoll.setRollType(sysParamOper.getSysParamItemName(archivesRoll.getRollType()));
    archivesRoll.setRollStatus(sysParamOper.getSysParamItemName(archivesRoll.getRollStatus()));
    archivesRoll.setMediaType(sysParamOper.getSysParamItemName(archivesRoll.getMediaType()));
    archivesRoll.setUnit(sysParamOper.getSysParamItemName(archivesRoll.getUnit()));
    archivesRoll.setSecretNum(sysParamOper.getSysParamItemName(archivesRoll.getSecretNum()));
    archivesRoll.setStoreTime(sysParamOper.getSysParamItemName(archivesRoll.getStoreTime()));
    archivesRoll.setSpecs(sysParamOper.getSysParamItemName(archivesRoll.getSpecs()));
  }

  public static void archivesRollList(List list) {
    for (int i = 0; i < list.size(); i++) {
      ArchivesRoll archivesRoll = (ArchivesRoll) list.get(i);
      archivesRoll(archivesRoll);
    }
  }

  public static void archivesPiece(ArchivesPiece archivesPiece) {
    archivesPiece.setManuScript(sysParamOper.getSysParamItemName(archivesPiece.getManuScript()));
    archivesPiece.setSecretNum(sysParamOper.getSysParamItemName(archivesPiece.getSecretNum()));
    archivesPiece.setPieceStoreTime(sysParamOper.getSysParamItemName(archivesPiece.getPieceStoreTime()));
    archivesPiece.setPieceMediaType(sysParamOper.getSysParamItemName(archivesPiece.getPieceMediaType()));
    archivesPiece.setPieceSpecs(sysParamOper.getSysParamItemName(archivesPiece.getPieceSpecs()));
  }

  public static void archivesPieceList(List list) {
    for (int i = 0; i < list.size(); i++) {
      ArchivesPiece archivesPiece = (ArchivesPiece) list.get(i);
      archivesPiece(archivesPiece);
    }
  }

  public static void archivesPage(ArchivesPage archivesPage) {

    archivesPage.setQuerySecret(sysParamOper.getSysParamItemName(archivesPage.getQuerySecret()));

    String objectStatus = archivesPage.getObjectStatus();
    if ("PASS".equalsIgnoreCase(objectStatus)) {
      archivesPage.setObjectStatus("检查通过");
    }
    else if ("NOPASS".equalsIgnoreCase(objectStatus)) {
      archivesPage.setObjectStatus("检查未通过");
    }
    else if ("RESCAN".equalsIgnoreCase(objectStatus)) {
      archivesPage.setObjectStatus("重扫");
    }
    else if ("ADD88".equalsIgnoreCase(objectStatus)) {
      archivesPage.setObjectStatus("补扫");
    }
    else {
      archivesPage.setObjectStatus("");
    }

    String objectMode = archivesPage.getObjectMode();
    if ("1".equalsIgnoreCase(objectStatus)) {
      archivesPage.setObjectMode("档案对象");
    }
    else if ("2".equalsIgnoreCase(objectStatus)) {
      archivesPage.setObjectMode("背景资料");
    }
    else {
      archivesPage.setObjectMode("");
    }

    archivesPage.setDataType(sysParamOper.getSysParamItemName(archivesPage.getDataType()));

  }

  public static void archivesPageList(List list) {
    for (int i = 0; i < list.size(); i++) {
      ArchivesPage archivesPage = (ArchivesPage) list.get(i);
      archivesPage(archivesPage);
    }
  }
*/
}