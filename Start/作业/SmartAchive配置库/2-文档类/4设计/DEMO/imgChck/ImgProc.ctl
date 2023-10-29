VERSION 5.00
Object = "{6D940288-9F11-11CE-83FD-02608C3EC08A}#2.2#0"; "Imgedit.ocx"
Begin VB.UserControl ImgProc 
   ClientHeight    =   8145
   ClientLeft      =   0
   ClientTop       =   0
   ClientWidth     =   8505
   ScaleHeight     =   8145
   ScaleWidth      =   8505
   Begin ImgeditLibCtl.ImgEdit ImgEdit2 
      Height          =   5760
      Left            =   3510
      TabIndex        =   2
      Top             =   1650
      Width           =   3975
      _Version        =   131074
      _ExtentX        =   7011
      _ExtentY        =   10160
      _StockProps     =   96
      BorderStyle     =   1
      ImageControl    =   "ImgEdit"
      UndoBufferSize  =   82675968
      OcrZoneVisibility=   -3292
      AnnotationOcrType=   25649
      ForceFileLinking1x=   -1  'True
      MagnifierZoom   =   25649
      sReserved1      =   -3292
      sReserved2      =   -3292
      lReserved1      =   1241952
      lReserved2      =   1241952
      bReserved1      =   -1  'True
      bReserved2      =   -1  'True
   End
   Begin VB.Frame FrameBtn 
      Caption         =   "ͼ����"
      Height          =   825
      Left            =   45
      TabIndex        =   1
      Top             =   30
      Width           =   8385
      Begin VB.CommandButton cmdPreview 
         Caption         =   "Ԥ��"
         Height          =   360
         Left            =   5805
         TabIndex        =   10
         Top             =   315
         Width           =   885
      End
      Begin VB.CommandButton cmdApply 
         Caption         =   "����Ԥ��"
         Height          =   360
         Left            =   6735
         TabIndex        =   9
         Top             =   315
         Visible         =   0   'False
         Width           =   885
      End
      Begin VB.CommandButton cmdAutoRotate 
         Caption         =   "�Զ���ƫ"
         Height          =   360
         Left            =   195
         TabIndex        =   8
         Top             =   315
         Width           =   885
      End
      Begin VB.CommandButton cmdDeleteArea 
         Caption         =   "ɾ������"
         Height          =   360
         Left            =   3015
         TabIndex        =   7
         Top             =   315
         Width           =   885
      End
      Begin VB.CommandButton cmdInterceptArea 
         Caption         =   "��ȡ"
         Height          =   360
         Left            =   3945
         TabIndex        =   6
         Top             =   315
         Width           =   885
      End
      Begin VB.CommandButton cmdCutPoint 
         Caption         =   "ȥ�۵�"
         Height          =   360
         Left            =   2070
         TabIndex        =   5
         Top             =   315
         Width           =   885
      End
      Begin VB.CommandButton cmdCutBlank 
         Caption         =   "ȥ�ڱ�"
         Height          =   360
         Left            =   1140
         TabIndex        =   4
         Top             =   315
         Width           =   885
      End
      Begin VB.CommandButton cmdRotate 
         Caption         =   "��ƫ"
         Height          =   360
         Left            =   4875
         TabIndex        =   3
         Top             =   315
         Width           =   885
      End
   End
   Begin ImgeditLibCtl.ImgEdit ImgEdit1 
      Height          =   2730
      Left            =   45
      TabIndex        =   0
      Top             =   900
      Width           =   2805
      _Version        =   131074
      _ExtentX        =   4948
      _ExtentY        =   4815
      _StockProps     =   96
      BorderStyle     =   1
      ImageControl    =   "ImgEdit"
      UndoBufferSize  =   82675968
      OcrZoneVisibility=   -3292
      AnnotationOcrType=   25649
      ForceFileLinking1x=   -1  'True
      MagnifierZoom   =   25649
      sReserved1      =   -3292
      sReserved2      =   -3292
      lReserved1      =   1241952
      lReserved2      =   1241952
      bReserved1      =   -1  'True
      bReserved2      =   -1  'True
   End
   Begin VB.Menu mnu_Image 
      Caption         =   ""
      Begin VB.Menu mnu_ZoomOut 
         Caption         =   "�Ŵ�(&O)"
      End
      Begin VB.Menu mnu_ZoomIn 
         Caption         =   "��С(&I)"
      End
      Begin VB.Menu mnu_ImageSize 
         Caption         =   "ͼ���С(&S)"
      End
      Begin VB.Menu mnu_Fit 
         Caption         =   "��Ӧ����(&F)"
      End
   End
End
Attribute VB_Name = "ImgProc"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = True
Option Explicit

Private mbFrameBtnVisible As Boolean        '�Ƿ���ʾ���������ť
Private mbPreview As Boolean                '�Ƿ���Ԥ������
Private mbPreviewing As Boolean             '�Ƿ���Ԥ�������ļ�

Dim m_sFileName As String
Dim m_sNewFileName As String

Dim m_lngLeft    As Long
Dim m_lngRight   As Long
Dim m_lngTop     As Long
Dim m_lngBottom  As Long

'
'���ܣ������Ƿ���Ԥ������
'
Public Sub SetPreview(ByVal bPreview As Boolean)
    mbPreview = bPreview
    If mbPreview = False Then
        cmdPreview.Caption = "Ԥ��"
    Else
        cmdPreview.Caption = "ȡ��Ԥ��"
    End If
    
    Call FitScreen
End Sub

'
'���ܣ����ñ��水ť������
'
Public Sub SetCaption(ByVal sCaption As String)
    cmdApply.Caption = sCaption
End Sub

'
'���ܣ������Ƿ���ʾͼ�������ť
'
Public Sub SetShowButton(ByVal bShow As Boolean)
    mbFrameBtnVisible = bShow
    Call FitScreen
End Sub

Public Function GetPreviewStatus() As Boolean
    GetPreviewStatus = mbPreview
End Function

Public Function GetShowButton() As Boolean
    GetShowButton = mbFrameBtnVisible
End Function


'
'���ܣ���ʾͼ��
'���أ��ɹ�true ʧ��false
'
Public Function ShowPicture(ByVal sFile As String) As Boolean
    On Error GoTo ErrorHandle
    
        
    ImgEdit2.Image = ""
    ImgEdit2.ClearDisplay
    
    ImgEdit1.Image = sFile
    ImgEdit1.Display
    ImgEdit1.Refresh
    
    ImgEdit1.FitTo 0, True
    ImgEdit1.Refresh
    
    m_lngLeft = -1
    m_lngRight = -1
    m_lngTop = -1
    m_lngBottom = -1
    
    m_sFileName = sFile
    m_sNewFileName = ""
    mbPreviewing = False
    
    ShowPicture = True
    Exit Function
ErrorHandle:
    Call Clear
    
    ShowPicture = False
End Function

'
'���ܣ�����ͼ������������ˢ����ʾ
'
Public Function ApplyPreview() As Boolean
    On Error GoTo ErrorHandle
    Dim bRet As Boolean
      
    If (m_sFileName <> "") And (mbPreview = True) And (mbPreviewing = True) And (m_sNewFileName <> "") Then
        FileCopy m_sNewFileName, m_sFileName
        
        Call ShowPicture(m_sFileName)
        mbPreviewing = False
        m_sNewFileName = ""
    End If
    
    bRet = True
    GoTo ExitHandle
ErrorHandle:
    bRet = False
    MsgBox "Error: " & Err.Number & " Err.Source: " & Err.Source & Chr(13) & Chr(10) & _
            Err.Description & IIf(Erl <> 0, Erl, ""), vbInformation
ExitHandle:
    ApplyPreview = bRet
End Function

'
'���ܣ��Զ���ƫ
'
Public Sub AutoRotate()
    On Error GoTo ErrorHandle
    
    Dim ret As Integer
    Dim srcImage, desImage As String
    
    If (m_sFileName = "") Then Exit Sub
    
    srcImage = m_sFileName
    If mbPreview = True Then
        desImage = App.Path & "\~~tmp" & getFileType(srcImage) ' "~~tmp.bmp"
    Else
        desImage = m_sFileName
    End If
        
    Dim tSkew As SKEWINFO
    ret = DeskewProc(srcImage, desImage, tSkew)
    If (ret < 0) Then
        MsgBox "�Զ���ƫʧ��!"
        Exit Sub
    End If
    'MsgBox "��ƫ�Ƕȣ�" & tSkew.SkewAngle
    
    If mbPreview = True Then
        mbPreviewing = True
        
        ImgEdit2.Visible = True
        
        ImgEdit2.Image = desImage
        ImgEdit2.Display
        ImgEdit2.Refresh
        
        ImgEdit2.FitTo 0, True
        ImgEdit2.Display
    Else
        mbPreviewing = False
        ImgEdit1.Image = desImage
        ImgEdit1.Display
        ImgEdit1.Refresh
    End If
    
    m_sNewFileName = desImage
    Exit Sub
ErrorHandle:
    m_sNewFileName = ""
    MsgBox "Error: " & Err.Number & " Err.Source: " & Err.Source & Chr(13) & Chr(10) & _
            Err.Description & IIf(Erl <> 0, Erl, ""), vbInformation
End Sub

' Description:       С�ǶȾ�ƫ
' Date-Time  :       2003-9-5-11:49:31
Public Sub Round()
    On Error GoTo ErrorHandle
    
    Dim angle As String
    Dim nResult As Integer
    
    angle = InputBox("��������ת�Ƕ�ֵ��˳ʱ�� +����ʱ�� -����", "����Ƕ���ת")
    If angle <> "" Then
        If IsNumeric(angle) = False Then
            MsgBox "��ת�ĽǶȱ��������֣�", vbExclamation + vbOKOnly
            angle = InputBox("��������ת�Ƕ�ֵ��˳ʱ�� +����ʱ�� -����", "����Ƕ���ת")
            If angle = "" Then
                GoTo ExitHandle
            Else
                If IsNumeric(angle) = False Then
                    GoTo ExitHandle
                End If
            End If
         End If
         If angle < -360 Or angle > 360 Then
            MsgBox "����ĽǶȳ���ָ����Χ��", vbExclamation + vbOKOnly
            GoTo ExitHandle
         End If
    Else
        GoTo ExitHandle
    End If
    
    Dim srcImage, desImage As String
    If (m_sFileName = "") Then Exit Sub
    srcImage = m_sFileName
    If mbPreview = True Then
        desImage = App.Path & "\~~tmp" & getFileType(srcImage) ' "~~tmp.bmp"
    Else
        desImage = m_sFileName
    End If
    
    nResult = ImgFileRotate(srcImage, desImage, 0, CSng(angle), 1)
    If nResult <> 1 Then
        MsgBox "С�ǶȾ�ƫʧ�ܣ�"
        GoTo ExitHandle
    End If
    
    'ˢ����ʾ
    If mbPreview = True Then
        mbPreviewing = True
        ImgEdit2.Visible = True
        
        ImgEdit2.Image = desImage
        ImgEdit2.Display
        ImgEdit2.Refresh
        
        ImgEdit2.FitTo 0, True
        ImgEdit2.Display
    Else
        mbPreviewing = False
        ImgEdit1.Image = desImage
        ImgEdit1.Display
        ImgEdit1.Refresh
    End If
    
    m_sNewFileName = desImage
    GoTo ExitHandle
ErrorHandle:
    MsgBox "С�ǶȾ�ƫʧ�ܣ�" & vbCrLf & Err.Description, vbInformation
ExitHandle:
    
End Sub


'
'���ܣ�ȥ�ڱ�
'
Public Sub CutBlank(ByVal nWidth As Integer)
    On Error GoTo ErrorHandle
    
    Dim ret As Integer
    Dim srcImage, desImage As String
    
    If (m_sFileName = "") Then Exit Sub
    
    srcImage = m_sFileName
    If mbPreview = True Then
        desImage = App.Path & "\~~tmp" & getFileType(srcImage) ' "~~tmp.bmp"
    Else
        desImage = m_sFileName
    End If
    
    ret = BlackBorderProc(srcImage, desImage, False, nWidth)
    If (ret < 0) Then
        MsgBox "ȥ�ڱ�ʧ��!"
        Exit Sub
    End If
    
    If mbPreview = True Then
        mbPreviewing = True
        ImgEdit2.Visible = True
        
        ImgEdit2.Image = desImage
        ImgEdit2.Display
        ImgEdit2.Refresh
        
        ImgEdit2.FitTo 0, True
        ImgEdit2.Display
    Else
        mbPreviewing = False
        ImgEdit1.Image = desImage
        ImgEdit1.Display
        ImgEdit1.Refresh
    End If
    
    m_sNewFileName = desImage
    Exit Sub
ErrorHandle:
    m_sNewFileName = ""
    MsgBox "Error " & Err.Number & " Err.Source " & Err.Source & Chr(13) & Chr(10) & _
            Err.Description & IIf(Erl <> 0, Erl, ""), vbInformation
End Sub

'
'���ܣ�ȥ�۵�
'
Public Sub CutPoint(ByVal nWidth As Integer, ByVal nHeight As Integer)
    On Error GoTo ErrorHandle
    
    Dim ret As Integer
    Dim srcImage, desImage As String

    If (m_sFileName = "") Then Exit Sub
    
    srcImage = m_sFileName
    If mbPreview = True Then
        desImage = App.Path & "\~~tmp" & getFileType(srcImage) ' "~~tmp.bmp"
    Else
        desImage = m_sFileName
    End If
    
    ret = DespeckleProc(srcImage, desImage, nWidth, nHeight)
    If ret < 0 Then
        MsgBox "ȥ�۵�ʧ��"
        Exit Sub
    End If
    
    If mbPreview = True Then
        mbPreviewing = True
        ImgEdit2.Visible = True
        
        ImgEdit2.Image = desImage
        ImgEdit2.Display
        ImgEdit2.Refresh
        
        ImgEdit2.FitTo 0, True
        ImgEdit2.Display
    Else
        mbPreviewing = False
        ImgEdit1.Image = desImage
        ImgEdit1.Display
        ImgEdit1.Refresh
    End If
    
    m_sNewFileName = desImage
    Exit Sub
ErrorHandle:
    m_sNewFileName = ""
    MsgBox "Error: " & Err.Number & " Err.Source: " & Err.Source & Chr(13) & Chr(10) & _
            Err.Description & IIf(Erl <> 0, Erl, ""), vbInformation

End Sub



'
'���ܣ�����ѡ�е�����
'
Public Function GetRegion() As String
    On Error GoTo ErrorHandle
    Dim sRet As String
    
    sRet = ""
    If (ImgEdit1.SelectionRectangle = True) And (m_lngBottom >= 0) And (m_lngLeft >= 0) And (m_lngRight >= 0) And (m_lngTop >= 0) Then
        sRet = CStr(m_lngLeft) & ", " & CStr(m_lngTop) & ", " & CStr(m_lngRight - m_lngLeft) & ", " & CStr(m_lngBottom - m_lngTop)
    End If
    GoTo ExitHandle
ErrorHandle:
    sRet = ""
ExitHandle:
    GetRegion = sRet
End Function


' Description:       ɾ��ͼ������
' Date-Time  :       2003-9-5-11:45:47
Public Sub DeleteArea()
    On Error GoTo ErrorHandle
    Dim nResult As Integer
    Dim srcImage, desImage As String
    
    If (m_sFileName = "") Then Exit Sub
    
    srcImage = m_sFileName
    If mbPreview = True Then
        desImage = App.Path & "\~~tmp" & getFileType(srcImage) ' "~~tmp.bmp"
    Else
        desImage = m_sFileName
    End If
    
    If (ImgEdit1.SelectionRectangle = False) Or (m_lngBottom < 0) Or (m_lngLeft < 0) Or (m_lngRight < 0) Or (m_lngTop < 0) Then
        MsgBox "�Բ�������ѡ��Ҫɾ����ͼ������", vbInformation
        GoTo ExitHandle
    End If
    
    nResult = ImgFileDelete(srcImage, desImage, 0, m_lngLeft, m_lngTop, m_lngRight, m_lngBottom, 16777215)
    If nResult <> 1 Then
        MsgBox "ɾ��ͼ������ʧ�ܣ�", vbInformation
        GoTo ExitHandle
    End If
        
    'ˢ����ʾ��ǰҳ��
    If mbPreview = True Then
        mbPreviewing = True
        ImgEdit2.Visible = True
        
        ImgEdit2.Image = desImage
        ImgEdit2.Display
        ImgEdit2.Refresh
        
        ImgEdit2.FitTo 0, True
        ImgEdit2.Display
    Else
        mbPreviewing = False
        ImgEdit1.Image = desImage
        ImgEdit1.Display
        ImgEdit1.Refresh
    End If
    
    m_sNewFileName = desImage
    GoTo ExitHandle
ErrorHandle:
    MsgBox "ɾ��ͼ������ʧ�ܣ�" & vbCrLf & Err.Description, vbInformation
ExitHandle:
    
End Sub

' Description:       ͼ���ȡ
' Date-Time  :       2003-9-11-11:48:48
Public Sub InterceptArea()
    On Error GoTo ErrorHandle
    Dim nResult As Integer
    Dim srcImage, desImage As String
    
    If (m_sFileName = "") Then Exit Sub
    
    srcImage = m_sFileName
    If mbPreview = True Then
        desImage = App.Path & "\~~tmp" & getFileType(srcImage) ' "~~tmp.bmp"
        FileCopy srcImage, desImage
    Else
        desImage = m_sFileName
    End If
    
    If (ImgEdit1.SelectionRectangle = False) Or (m_lngBottom < 0) Or (m_lngLeft < 0) Or (m_lngRight < 0) Or (m_lngTop < 0) Then
        MsgBox "�Բ�������ѡ��Ҫ��ȡ��ͼ������", vbInformation
        GoTo ExitHandle
    End If
    
    nResult = ImgSameFileCutPaste(desImage, m_lngLeft, m_lngTop, m_lngRight, m_lngBottom)
    If nResult <> 1 Then
        MsgBox "ͼ���ȡʧ�ܣ�", vbInformation
        GoTo ExitHandle
    End If
    
    'ˢ����ʾ��ǰҳ��
    If mbPreview = True Then
        mbPreviewing = True
        ImgEdit2.Visible = True
        
        ImgEdit2.Image = desImage
        ImgEdit2.Display
        ImgEdit2.Refresh
        
        ImgEdit2.FitTo 0, True
        ImgEdit2.Display
    Else
        mbPreviewing = False
        ImgEdit1.Image = desImage
        ImgEdit1.Display
        ImgEdit1.Refresh
    End If
    
    m_sNewFileName = desImage
    GoTo ExitHandle
ErrorHandle:
    MsgBox "��ȡͼ������ʧ�ܣ�" & vbCrLf & Err.Description, vbInformation
ExitHandle:
    
End Sub
'
'���ܣ������ʾ�����³�ʼ��
'
Public Function Clear() As Boolean
    On Error Resume Next
    m_sFileName = ""
    m_sNewFileName = ""
    
    m_lngLeft = -1
    m_lngRight = -1
    m_lngTop = -1
    m_lngBottom = -1
    mbPreviewing = False
    
    ImgEdit1.Image = ""
    ImgEdit1.ClearDisplay
    ImgEdit2.Image = ""
    ImgEdit2.ClearDisplay
    
    Clear = True
End Function

Private Sub cmdApply_Click()
    Call ApplyPreview
End Sub

Private Sub cmdAutoRotate_Click()
    Call AutoRotate
End Sub

Private Sub cmdCutBlank_Click()
    Call CutBlank(3)
End Sub

Private Sub cmdCutPoint_Click()
    Call CutPoint(5, 5)
End Sub

Private Sub cmdDeleteArea_Click()
    Call DeleteArea
End Sub

Private Sub cmdInterceptArea_Click()
    Call InterceptArea
End Sub

Private Sub cmdPreview_Click()
    If mbPreview = False Then
        Call SetPreview(True)
    Else
        Call SetPreview(False)
    End If
End Sub

Private Sub cmdRotate_Click()
    Call Round
End Sub

Private Sub ImgEdit1_MouseUp(Button As Integer, Shift As Integer, x As Single, y As Single)
    If (Button = 2) And (ImgEdit1.ImageDisplayed) Then
        mnu_Image.Tag = 1
        PopupMenu mnu_Image
    End If
End Sub

'
'ѡ������
'
Private Sub ImgEdit1_SelectionRectDrawn(ByVal left As Long, ByVal top As Long, ByVal Width As Long, ByVal Height As Long)
    If Width = 0 Or Height = 0 Then
        m_lngBottom = -1
        m_lngLeft = -1
        m_lngTop = -1
        m_lngRight = -1
    Else
        m_lngLeft = (left + ImgEdit1.ScrollPositionX) * 100 / ImgEdit1.Zoom
        m_lngRight = m_lngLeft + Width * 100 / ImgEdit1.Zoom
        m_lngTop = (top + ImgEdit1.ScrollPositionY) * 100 / ImgEdit1.Zoom
        m_lngBottom = m_lngTop + Height * 100 / ImgEdit1.Zoom
    End If
End Sub

Private Sub ImgEdit2_MouseUp(Button As Integer, Shift As Integer, x As Single, y As Single)
    If (Button = 2) And (ImgEdit2.ImageDisplayed) Then
        mnu_Image.Tag = 2
        PopupMenu mnu_Image
    End If
End Sub

'
'ͼ����ʾ����Ӧ���ڴ�С
'
Private Sub mnu_Fit_Click()
    On Error GoTo ErrorHandle
    If mnu_Image.Tag = 1 Then
        ImgEdit1.FitTo 0, True
        ImgEdit1.Refresh
    Else
        ImgEdit2.FitTo 0, True
        ImgEdit2.Refresh
    End If
ErrorHandle:
End Sub

'
'���ܣ�ͼ����ʾ��ʵ�ʴ�С
'
Private Sub mnu_ImageSize_Click()
    On Error GoTo ErrorHandle
    If mnu_Image.Tag = 1 Then
        ImgEdit1.Zoom = 100
        ImgEdit1.Refresh
    Else
        ImgEdit2.Zoom = 100
        ImgEdit2.Refresh
    End If
    Exit Sub
ErrorHandle:
End Sub


'
'�Ŵ�
'
Private Sub mnu_ZoomOut_Click()
    On Error GoTo ErrorHandle
    If mnu_Image.Tag = 1 Then
        ImgEdit1.Zoom = ImgEdit1.Zoom + 10
        ImgEdit1.Refresh
    Else
        ImgEdit2.Zoom = ImgEdit2.Zoom + 10
        ImgEdit2.Refresh
    End If
    Exit Sub
ErrorHandle:
End Sub

'
'��С
'
Private Sub mnu_ZoomIn_Click()
    On Error GoTo ErrorHandle
    If mnu_Image.Tag = 1 Then
        ImgEdit1.Zoom = ImgEdit1.Zoom - 10
        ImgEdit1.Refresh
    Else
        ImgEdit2.Zoom = ImgEdit2.Zoom - 10
        ImgEdit2.Refresh
    End If
    Exit Sub
ErrorHandle:
End Sub



Private Sub UserControl_Initialize()
    Call Clear
    
    Call SetShowButton(False)
    Call SetPreview(False)
    
End Sub

Private Sub UserControl_Resize()
    Call FitScreen
End Sub

'
'���ܣ����������Զ�����������ʾ��С
'
Private Sub FitScreen()
    ImgEdit1.left = 0
    ImgEdit1.top = 0
    ImgEdit1.Height = UserControl.Height - ImgEdit1.top
    ImgEdit1.Width = UserControl.Width - ImgEdit1.left * 2
    
    '������ť
    If mbFrameBtnVisible = True Then
        FrameBtn.Visible = True
        
        FrameBtn.Width = UserControl.Width - FrameBtn.left * 2
        ImgEdit1.top = FrameBtn.top + FrameBtn.Height
        ImgEdit1.Height = UserControl.Height - ImgEdit1.top
    Else
        FrameBtn.Visible = False
    End If
    
    'Ԥ��
    If mbPreview = True Then
        cmdApply.Visible = True
        ImgEdit2.Visible = True
        
        ImgEdit1.Width = (UserControl.Width / 2) - ImgEdit1.left * 2
    
        ImgEdit2.top = ImgEdit1.top
        ImgEdit2.left = (UserControl.Width / 2)
        ImgEdit2.Width = ImgEdit1.Width
        ImgEdit2.Height = ImgEdit1.Height
    Else
        ImgEdit2.Visible = False
        cmdApply.Visible = False
    End If
End Sub

Private Function getFileType(ByVal sFile As String) As String
    Dim n As Integer
    Dim sRet As String
    
    On Error GoTo ErrorHandle
    
    For n = Len(sFile) To 1 Step -1
        If Mid(sFile, n, 1) = "\" Then
            getFileType = ""
            Exit For
        End If
        If Mid(sFile, n, 1) = "." Then
            getFileType = Mid(sFile, n, Len(sFile))
            Exit For
        End If
    Next n
    
    Exit Function
ErrorHandle:
    getFileType = ""
End Function
