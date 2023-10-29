Attribute VB_Name = "mdlDeclare"
Option Explicit


'ocr识别接口函数


'图象自动去黑边、纠偏
Public Declare Function BlackBorderProc Lib "WImageTool.dll" (ByVal SrcFileName As String, ByVal DesFileName As String, ByVal IsCrop As Boolean, ByVal WhiteNoiseGap As Integer) As Integer
Public Declare Function DeskewProc Lib "WImageTool.dll" (ByVal SrcFileName As String, ByVal DesFileName As String, tSkew As SKEWINFO) As Integer
Public Declare Function DespeckleProc Lib "WImageTool.dll" (ByVal SrcFileName As String, ByVal DesFileName As String, ByVal MaxiWidth As Long, ByVal MaxiHeight As Long) As Integer

Public Declare Function MarkUpProc Lib "WImageTool.dll" (ByVal SrcFileName As String, ByVal DesFileName As String, tFontInfo As FONTINFO, tGraphInfo As GRAPHINFO, ByVal IsShowDlg As Boolean) As Integer
Public Declare Function ComposeImages Lib "WImageTool.dll" (ByVal MasterImgName As String, ByVal SlaveImgName As String, ByVal DesFileName As String, ByVal Pos_X As Long, ByVal Pos_Y As Long, ByVal IsTrans As Boolean) As Integer


'打开、存储、关闭图像文件
Public Declare Function OpenImgFile Lib "ImagePro.dll" (ByVal strFilePath As String) As Long
Public Declare Function GetImgPageCount Lib "ImagePro.dll" () As Long
Public Declare Function GetPageHDIB Lib "ImagePro.dll" (ByVal nPage As Long) As Long

Public Declare Function SaveImgPage Lib "ImagePro.dll" (ByVal strSavePath As String, ByVal nPage As Long) As Long
Public Declare Function SaveImgFile Lib "ImagePro.dll" (ByVal hDib As Long, ByVal strSavePath As String) As Long
Public Declare Function CloseImgFile Lib "ImagePro.dll" () As Long

'图像旋转
Public Declare Function ImgRotate Lib "ImagePro.dll" (ByVal hDib As Long, ByVal angle As Single, ByVal bckgndWhite As Long) As Long
Public Declare Function ImgPageRotate Lib "ImagePro.dll" (ByVal nPage As Long, ByVal strSavePath As String, ByVal angle As Single, ByVal bckgndWhite As Long) As Long
Public Declare Function ImgFileRotate Lib "ImagePro.dll" (ByVal strSrcFilePath As String, ByVal strDstFilePath As String, ByVal nPage As Long, ByVal angle As Single, ByVal bckgndWhite As Long) As Long


'图像剪切, 参数left、right、top、bottom以图像左上角为原点
Public Declare Function ImgCrop Lib "ImagePro.dll" (ByVal hDib As Long, ByVal left As Long, ByVal top As Long, ByVal right As Long, ByVal bottom As Long) As Long
Public Declare Function ImgPageCrop Lib "ImagePro.dll" (ByVal nPage As Long, ByVal strSavePath As String, ByVal left As Long, ByVal top As Long, ByVal right As Long, ByVal bottom As Long) As Long
Public Declare Function ImgFileCrop Lib "ImagePro.dll" (ByVal strSrcFilePath As String, ByVal strDstFilePath As String, ByVal nPage As Long, ByVal left As Long, ByVal top As Long, ByVal right As Long, ByVal bottom As Long) As Long


'图像区域删除，参数left、right、top、bottom以图像左上角为原点
Public Declare Function ImgDelete Lib "ImagePro.dll" (ByVal hDib As Long, ByVal left As Long, ByVal top As Long, ByVal right As Long, ByVal bottom As Long, ByVal color As Long) As Long
Public Declare Function ImgPageDelete Lib "ImagePro.dll" (ByVal nPage As Long, ByVal strSavePath As String, ByVal left As Long, ByVal top As Long, ByVal right As Long, ByVal bottom As Long, ByVal color As Long) As Long
Public Declare Function ImgFileDelete Lib "ImagePro.dll" (ByVal strSrcFilePath As String, ByVal strDstFilePath As String, ByVal nPage As Long, ByVal left As Long, ByVal top As Long, ByVal right As Long, ByVal bottom As Long, ByVal color As Long) As Long


'图像去噪声，参数Width、Height指噪声点的长高
Public Declare Function ImgClearNoise Lib "ImagePro.dll" (ByVal hDib As Long, ByVal Width As Long, ByVal Height As Long) As Long
Public Declare Function ImgPageClearNoise Lib "ImagePro.dll" (ByVal nPage As Long, ByVal strSavePath As String, ByVal Width As Long, ByVal Height As Long) As Long
Public Declare Function ImgFileClearNoise Lib "ImagePro.dll" (ByVal strSrcFilePath As String, ByVal strDstFilePath As String, ByVal nPage As Long, ByVal Width As Long, ByVal Height As Long) As Long


'图像去黑边
Public Declare Function ImgCutMargin Lib "ImagePro.dll" (ByVal hDib As Long) As Long
Public Declare Function ImgPageCutMargin Lib "ImagePro.dll" (ByVal nPage As Long, ByVal strSavePath As String) As Long
Public Declare Function ImgFileCutMargin Lib "ImagePro.dll" (ByVal strSrcFilePath As String, ByVal strDstFilePath As String, ByVal nPage As Long) As Long


'图像标记，输出图像的位数同输入图像中位数高的图像
Public Declare Function ImgMark Lib "ImagePro.dll" (ByVal hSrcDib As Long, ByVal hMarkDib As Long, ByVal pt_x As Long, ByVal pt_y As Long, ByVal IsGraphTrans As Long) As Long
Public Declare Function ImgPageMark Lib "ImagePro.dll" (ByVal nPage As Long, ByVal strSavePath As String, ByVal hMarkDib As Long, ByVal pt_x As Long, ByVal pt_y As Long, ByVal IsGraphTrans As Long) As Long
Public Declare Function ImgFileMark Lib "ImagePro.dll" (ByVal strSrcFilePath As String, ByVal strDstFilePath As String, ByVal nPage As Long, ByVal hMarkDib As Long, ByVal pt_x As Long, ByVal pt_y As Long, ByVal IsGraphTrans As Long) As Long
Public Declare Function ImgFilePaste Lib "ImagePro.dll" (ByVal strSrcFilePath As String, ByVal strDstFilePath As String, ByVal pt_x As Long, ByVal pt_y As Long, ByVal bIsGraphTrans As Long) As Long

Public Declare Function FreeHDIB Lib "ImagePro.dll" (ByVal hDib As Long) As Long
Public Declare Function GetErrString Lib "ImagePro.dll" () As String
Public Declare Function ImgSameFileCutPaste Lib "ImagePro.dll" (ByVal strSrcFilePath As String, ByVal left As Long, ByVal top As Long, ByVal right As Long, ByVal bottom As Long) As Long
Public Declare Function ImgDiffFileCutPaste Lib "ImagePro.dll" (ByVal strSrcFilePath As String, ByVal left As Long, ByVal top As Long, ByVal right As Long, ByVal bottom As Long, ByVal strDstFilePath As String, ByVal pt_x As Long, ByVal pt_y As Long, ByVal bIsGraphTrans As Long) As Long
Public Declare Function ImgAutoCorrect Lib "ImagePro.dll" (ByVal strFilePath As String) As Long


Public Const LF_FACESIZE = 32
Public Const OUT_TT_PRECIS = 4
Public Const CLIP_DEFAULT_PRECIS = 0
Public Const PROOF_QUALITY = 2
Public Const FF_SWISS = 32      '  Variable stroke width, sans-serifed.
Public Const VARIABLE_PITCH = 2

Public Type SKEWINFO
    SkewAngle As Double
End Type

Public Type LOGFONT
        lfHeight As Long
        lfWidth As Long
        lfEscapement As Long
        lfOrientation As Long
        lfWeight As Long
        lfItalic As Byte
        lfUnderline As Byte
        lfStrikeOut As Byte
        lfCharSet As Byte
        lfOutPrecision As Byte
        lfClipPrecision As Byte
        lfQuality As Byte
        lfPitchAndFamily As Byte
        lfFaceName(1 To LF_FACESIZE) As Byte
End Type

Public Type FONTINFO
    Pos_X As Long
    Pos_Y As Long
    MarkFont As LOGFONT
    MarkWords As String
    ArrayMethod As Long
    IsCharTrans As Long
    IsInGraphCenter As Boolean
End Type

Public Type GRAPHINFO
    GC_X As Long
    GC_Y As Long
    GX_L As Long
    GY_L As Long
    Graphtype As Long
    IsGraphTrans As Boolean
End Type



