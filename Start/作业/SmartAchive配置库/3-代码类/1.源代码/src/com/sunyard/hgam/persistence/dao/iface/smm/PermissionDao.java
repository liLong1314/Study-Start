package com.sunyard.hgam.persistence.dao.iface.smm;

import java.util.*;
import com.sunyard.hgam.persistence.dao.beans.smm.*;

/**
 * <p>Title: Hang Zhou Net Archives</p>
 * <p>Description: 杭州市网上档案馆建设（一期）</p>
 * <p>Copyright: Hangzhou Sunyard System Engineering， Ltd. All rights reserved @2003</p>
 * <p>Company: </p>
 * @author xcf
 * @version 1.00
 */

public interface PermissionDao
{
    public List getPermissionByCode(String permissionCode);
    public List getAllPermission();
    public List getAllPermissionByType(Permission p);
    public int insertPermission(Permission permission);
    public int updatePermission(Permission permission);
    public int deletePermission(Permission permission);
}