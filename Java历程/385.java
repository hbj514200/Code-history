import java.awt.*;                                                              //界面包
import javax.swing.*;                                                           //界面组件包
import java.awt.event.*;                                                        //界面动作包
import javax.swing.table.*;                                                     //电子表格包

class main extends JFrame {                                                 //主类，继承JFrame
private DefaultTableModel tableModel;                                           //定义： DedaultTableModel   表格模型
private JTable table;                                                           //定义： 表格JTable对象
private JTextField aTextField;                                                  //定义： 包括下面那个，文字框
private JTextField bTextField;

public static void main(String[] args) { 
     new main().setVisible(true);                                               //主main测试方法， 启动本类。
}
    
public main(){                                                              //主方法
    setTitle("表格维护模型");                                                    //设置主窗口标题名字
    setBounds(100,100,510,375);                                                 //设置主窗口的大小和位置
    setDefaultCloseOperation(EXIT_ON_CLOSE);                                    //设置主窗口的关闭方式
    JScrollPane mianban=new JScrollPane();                                      //新建了一个滚动面板mianban
    getContentPane().add(mianban, BorderLayout.CENTER);                         //把滚动面板加入界面容器的中间
    String[] columnNames={"A","B"};                                                 //表格列名，数组
    String[][] tableValues={{"A1","B1"}, {"A2", "B2"}, {"A3", "B3"}};               //表格内容， String二维数组
    tableModel=new DefaultTableModel(tableValues, columnNames);                     //实例化了tableModel的表格模型。（注意：不是表格对象）
    
    table=new JTable(tableModel);                                               //实例化table表格组件，传入电子表格模型
    table.setRowSorter(new TableRowSorter<>(tableModel));                           //为table表格对象设置排序器
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);                    //设置表格为单选的，
    table.addMouseListener(new MouseAdapter() {                                     //为表格添加鼠标适配， （其实为什么不是鼠标点击动作事件？）
        public void mouseClicked(MouseEvent e){                                         //固定方法（mouseClicked）鼠标点击，  接受的是鼠标事件
            int selectedRow=table.getSelectedRow();                                             //利用table表格对象的getSelectedRow方法获取目前被选中的那一行的号码
            Object oa=tableModel.getValueAt(selectedRow, 0);                                    //选中那行左边的表格内容，注意：Object返回，不是字符串！！！  （0基编号）
            Object ob=tableModel.getValueAt(selectedRow, 1);                                    //选中那行右边的表格内容，注意：Object返回，不是字符串！！！  （0基编号）                    
            aTextField.setText(oa.toString());                                                  //设置文本框的内容，  利用Object通用类中惯有的toStiring()方法得到目标字符串
            bTextField.setText(ob.toString());                                                 //设置文本框的内容，  利用Object通用类中惯有的toStiring()方法得到目标字符串                                  
        }
});
    mianban.setViewportView(table);                                             //在滚动面板中加入table表格， 注意表格加入面板要setViewportView(）,没法add
    JPanel mianban2=new JPanel();                                               //创建面板2， 也就是最下端的那一行（放按钮和文本框的）
    getContentPane().add(mianban2, BorderLayout.SOUTH);                             //把面板2加入到窗口最底部
    mianban2.add(new Label("A: "));                                                     //面板2添加组件：       文字标签A：
    aTextField=new JTextField("A4", 10);                                                //创建 左 文本框
    mianban2.add(aTextField);                                                           //面板2添加组件：       文本框  左
    mianban2.add(new JLabel("B: "));                                                    //面板2添加组件：       文字标签B：
    bTextField=new JTextField("B4", 10);                                                //面板2添加组件：       文本框  右
    mianban2.add(bTextField);                                                           //创建 左 文本框
    JButton addButton=new JButton("添加");                                       //创建一个新的按钮，“添加”
    addButton.addActionListener(new ActionListener() {                              //为“添加”按钮添加动作事件
        public void actionPerformed(ActionEvent e) {                                    //固定方法
            String[] rowValues={ aTextField.getText(), bTextField.getText() };              //创建了一个String数组， 利用的是两个文本框中的getText输入的字符串
            tableModel.addRow(rowValues);                                                   //利用tableModel的添加行
            int rowCount=table.getRowCount()+1;                                             //利用table的getRowCount返回目前表格总行数   
            aTextField.setText("A"+rowCount);                                               //把两个文本框的内容下移，指向下一行紧挨着的内容。
            bTextField.setText("B"+rowCount);                                               //把两个文本框的内容下移，指向下一行紧挨着的内容。
        }
    });
    mianban2.add(addButton);                                                    //向面板2添加组件：  "添加"按钮    
    JButton updButton=new JButton("修改");                                         //创建一个"修改"按钮
    updButton.addActionListener(new ActionListener() {                             //为"修改"按钮添加动作事件
        public void actionPerformed(ActionEvent e) {                                //固定动作响应方法
            int selectedRow=table.getSelectedRow();                                    //利用table的getSelectedRow返回目前被选中行的编号            
            if(selectedRow!=-1){                                                       //如果目前有被选中的单元
                tableModel.setValueAt(aTextField.getText(), selectedRow, 0);            //设置表格的值，左
                tableModel.setValueAt(bTextField.getText(), selectedRow, 1);            //设置表格的值，右
            }
        }
    });
    mianban2.add(updButton);                                                     //向面板2添加组件：  修改按钮
    
    JButton delButton=new JButton("删除");                                       //新建一个“删除”按钮
    delButton.addActionListener(new ActionListener() {                           //为"修改"按钮添加动作事件
        public void actionPerformed(ActionEvent e) {                               //固定动作响应方法
            int selectedRow=table.getSelectedRow();                                  //利用table的getSelectedRow返回目前被选中行的编号 
            if(selectedRow!=-1){                                                     //如果目前有被选中的单元
                tableModel.removeRow(selectedRow);                                   //利用table表格的removeRow方法删除这一行
            }
        }
    });
    mianban2.add(delButton);                                                    //向面板2中添加组件：  删除按钮
}

}

//围标个设置排序器的语句：  table.setRowSorter(new TableRowSorter<>(tableModel));   也就是说必须要一个tableModel表格模型