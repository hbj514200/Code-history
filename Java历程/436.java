import java.awt.*;
import javax.swing.*;

class main extends JFrame {
    
    public static void main(String[] args) {
        new main().setVisible(true);
    }
    
public main(){
    setSize(320, 240);
    setResizable(false);
    setTitle("箱式布局管理器");
    Container cp=getContentPane();
    setDefaultCloseOperation(EXIT_ON_CLOSE);                                    // 以上五行是主窗口的基本属性设置
    
    Box box=Box.createVerticalBox();                                            // 创建了一个 垂直箱式布局管理器 box    （大窗口的大布局）
    cp.add(box, BorderLayout.CENTER);                                               // 把 box 加到界面容器的中间 
    box.add(Box.createVerticalStrut(5));                                            // box 添加了一个5像素的垂直支柱
    
    Box topicBox=Box.createHorizontalBox();                                     // 创建了一个顶部 水平箱式布局管理器 topicBox
    cp.add(topicBox, BorderLayout.NORTH);                                           // 把 topicBox 加入到界面容器的上方
    topicBox.add(Box.createHorizontalStrut(5));                                     // topicBox 里面放置一个5像素宽的水平支柱
    JLabel topiclabel=new JLabel("主题： ");                                         // 创建一个文字标签 topiclabel （内容：标题）
    topicBox.add(topiclabel);                                                           //把 topiclabel 加入到 topicBox 中 
    topicBox.add(Box.createHorizontalStrut(5));                                     // topicBox 里面放置一个5像素宽的水平支柱
    JTextField topicTextField=new JTextField(30);                                   // 创建一个标题文本框 topicTextField
    topicBox.add(topicTextField);                                                       //把 topicTextField 加入到 topicBox 中  
    
    Box contentBox=Box.createHorizontalBox();                                   // 创建了一个 水平箱式布局管理器 contentBox
    contentBox.setAlignmentX(1);                                                    // contenBox    水平调整：向右对齐
    box.add(contentBox);                                                        //把 contentBox 加入到主箱体 box 中
    contentBox.add(Box.createHorizontalStrut(5));                                   // contentBox 里面放置一个5像素宽的水平支柱
    JLabel contJLabel=new JLabel("内容： ");                                     // 创建一个文字标签 contlabel （内容：内容）
    contJLabel.setAlignmentY(0);                                                    // 标签 向上对齐
    contentBox.add(contJLabel);                                                     // 向 contBox 添加 contlabel
    contentBox.add(Box.createHorizontalStrut(5));                               // contBox 里面放置一个5像素宽的水平支柱
    
    JScrollPane mianban=new JScrollPane();                                      // 创建一个滚动小面板 mianban
    mianban.setAlignmentY(0);                                                       // 面板调整： 向上对齐
    contentBox.add(mianban);                                                        // 向 contBox 加入 mianban
    JTextArea contenTextArea=new JTextArea();                                       // 创建一个文本域 contTextArea
    contenTextArea.setLineWrap(true);                                                   // 设置文本域 自动换行
    mianban.setViewportView(contenTextArea);                                            //向 mianban 加入文本域 setViewportView
    box.add(Box.createVerticalStrut(5));                                        //box 添加 垂直支柱 （主布局）        
    
    JButton fasongButton=new JButton("确定");
    fasongButton.setAlignmentX(1);                                              //按钮 向右对齐
    box.add(fasongButton);
}
    
}

// 垂直箱体的分隔支柱也叫垂直支柱， 水平箱体的分隔支柱也叫水平支柱，    用于分开不同组件避免他们都粘在一起。add(Box.creat…………)
// 不同箱体可以交叉使用， 就像面板一样， 小面板加入大面板。
// 设置对齐时 其实用的是中间对齐方式，   例如这个组件的中线与上个组件的中线想做对齐……