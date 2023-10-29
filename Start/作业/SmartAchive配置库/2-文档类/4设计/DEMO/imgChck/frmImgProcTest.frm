VERSION 5.00
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "COMDLG32.OCX"
Object = "{A3135E4D-6269-4E88-A2A9-61C735C0FFC0}#5.0#0"; "ImgProc.ocx"
Begin VB.Form frmImgProcTest 
   Caption         =   "Form1"
   ClientHeight    =   7065
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   8085
   LinkTopic       =   "Form1"
   ScaleHeight     =   7065
   ScaleWidth      =   8085
   StartUpPosition =   3  '窗口缺省
   Begin VB.HScrollBar HScroll1 
      Height          =   300
      Left            =   3105
      Max             =   10
      TabIndex        =   6
      Top             =   5565
      Value           =   3
      Width           =   2250
   End
   Begin VB.CommandButton cmdCutBlank 
      Caption         =   "去黑边"
      Height          =   690
      Left            =   1650
      TabIndex        =   5
      Top             =   5145
      Width           =   1170
   End
   Begin VB.CommandButton cmdClear 
      Caption         =   "清空"
      Height          =   495
      Left            =   5835
      TabIndex        =   3
      Top             =   6330
      Width           =   1215
   End
   Begin MSComDlg.CommonDialog CommonDialog1 
      Left            =   3795
      Top             =   3285
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
      DefaultExt      =   "*.bmp"
      Filter          =   "*.bmp"
      InitDir         =   "f:\\"
   End
   Begin VB.CommandButton cmdPreview 
      Caption         =   "预览"
      Height          =   495
      Left            =   4470
      TabIndex        =   2
      Top             =   6300
      Width           =   1215
   End
   Begin VB.CommandButton cmdBtn 
      Caption         =   "显示操作按钮"
      Height          =   495
      Left            =   2985
      TabIndex        =   1
      Top             =   6270
      Width           =   1215
   End
   Begin VB.CommandButton cmdShow 
      Caption         =   "显示"
      Height          =   495
      Left            =   1500
      TabIndex        =   0
      Top             =   6315
      Width           =   1215
   End
   Begin ImgProcEx.ImgProc ImgProc1 
      Height          =   7005
      Left            =   0
      TabIndex        =   4
      Top             =   15
      Width           =   8085
      _ExtentX        =   14261
      _ExtentY        =   12356
   End
End
Attribute VB_Name = "frmImgProcTest"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Dim bPreview As Boolean
Dim bBtn As Boolean

Private Sub cmdBtn_Click()
    bBtn = Not bBtn
    ImgProc1.SetShowButton (bBtn)

End Sub

Private Sub cmdClear_Click()
    ImgProc1.Clear
End Sub

Private Sub cmdCutBlank_Click()
    ImgProc1.CutBlank (HScroll1.Value)
End Sub

Private Sub cmdPreview_Click()
    bPreview = Not bPreview
    Call ImgProc1.SetPreview(bPreview)
End Sub

Private Sub cmdShow_Click()
    CommonDialog1.ShowOpen
    If CommonDialog1.FileName <> "" Then
        ImgProc1.ShowPicture (CommonDialog1.FileName)
    End If
End Sub

Private Sub Form_Resize()
    cmdShow.Top = Me.Height - cmdShow.Height - 400
    cmdBtn.Top = cmdShow.Top
    cmdPreview.Top = cmdShow.Top
    cmdClear.Top = cmdShow.Top
    
    ImgProc1.Width = Me.Width
    ImgProc1.Height = Me.Height - cmdShow.Height - 200
End Sub
