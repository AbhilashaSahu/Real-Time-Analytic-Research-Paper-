package HW3.Main;
//import Main.populate;
//import Main.POPULATE;
import java.sql.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;   
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import static java.sql.Types.STRUCT;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import oracle.jdbc.OracleResultSet;
import static oracle.jdbc.OracleTypes.STRUCT;
import oracle.spatial.*;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.*;
//import oracle.jdbc.driver.OracleResultSet;



/**
 *
 * @author asahu
 */

public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    int mouseX=0,mouseY=0;
    String arg="";
    int pointQuery=0;
    static int queryCount=0;
    int noofpoints=0,lastx=-1,lasty=-1,firstx=-1,firsty=-1;
   database db=new database();
    String EQquery="",IDEQquery="";
    int regionClosed=0;
   Connection conn=db.getDBConnection();
    //Image img;
   // ImageIcon ii;
    ArrayList<Integer> poly_cord= new ArrayList<Integer>();
     
    // Boolean range_query_selected= false;
    // Boolean closest_fire_hydrant_selected=false;
      int count=1; int xfirst = 0,yfirst = 0;
      Polygon p= new Polygon();
   
   
  
    public GUI() {
        initComponents();
        db.getDBConnection();
     ImageIcon imgi = new ImageIcon("/home/asahu/Downloads/hw2_data/map.jpg");
         ii=imgi;
       jLabel3.setIcon(imgi);
       img=imgi.getImage();   
    }
    

 
      private void paintComponentPHOTOI(Graphics g,Color c,String query){
         try {
            
             OracleResultSet rs=(OracleResultSet)db.getQueryResult(query);
            g.setColor(c);
            while(rs.next()){
            STRUCT struct=(STRUCT)rs.getObject(1);
            Datum[] datum=((STRUCT)struct.getAttributes()[2]).getOracleAttributes();
            int radius= 3;
            g.drawOval(datum[0].intValue()-radius,datum[1].intValue()-radius,2*radius,2*radius);
            //int width=5;
            //g.drawRect(dat[0].intValue()-(width/2),dat[3].intValue()-(width/2),width,width);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }  
      }
      
    private void paintComponentBuildings(Graphics g,Color c,String query){
        
       try {
            OracleResultSet rs=(OracleResultSet)db.getQueryResult(query);
            g.setColor(c);
            while(rs.next()){
            STRUCT struct=(STRUCT)rs.getObject(1);
            oracle.sql.ARRAY arr= (oracle.sql.ARRAY) struct.getAttributes() [4];
            Datum[] datum=arr.getOracleArray();
            for(int i=0;i<datum.length-2;i+=2)
            {
                g.drawLine(datum[i].intValue(), datum[i+1].intValue(),datum[i+2].intValue(),datum[i+3].intValue());
            }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    private void paintComponentPHOTOGRAPHERI(Graphics g,Color c,String query){
        try {
            
            OracleResultSet rs=(OracleResultSet)db.getQueryResult(query);
            g.setColor(c);
            while(rs.next()){
            STRUCT struct=(STRUCT)rs.getObject(1);
            Datum[] datum=((STRUCT)struct.getAttributes()[2]).getOracleAttributes();
            g.drawRect(datum[0].intValue()-5, datum[1].intValue()-5,5,5);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     private void clear()
    {
        mouseX=-1;
        mouseY=-1;
        arg="";
        noofpoints=0;
        lastx=-1;
        lasty=-1;
        firstx=-1;
        firsty=-1;
        pointQuery=0;
        regionClosed=0;
    }
      private void paintComponentPoint(Graphics g,Color c,int x,int y)
    {  
            int radius=100;
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(c);
            Rectangle2D r2d = new Rectangle2D.Float(x-2.5f, y-2.5f,5f,5f);
            g2d.draw(r2d);
            g.drawOval(x-radius,y-radius,2*radius,2*radius);
    }
       private void paintComponentSquarePoint(Graphics g,Color c,int x,int y)
    {  
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(c);
            Rectangle2D r2d = new Rectangle2D.Float(x-2.5f, y-2.5f,5f,5f);
            g2d.draw(r2d);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setAutoscrolls(true);

        jLabel1.setText("Building");

        jLabel2.setText("jLabel2");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel4.setText("ABHILASHA SAHU                                                                                                                                                                                                                                                                                                  W1103561");

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(979, 979, 979)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("\" Abhilasha Sahu   W1103561 \"");
        setAlwaysOnTop(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Active Feature Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jCheckBox1.setText("Buildings");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("PHOTOI");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("PHOTOGRAPHERI");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                        .addComponent(jCheckBox3)
                        .addGap(63, 63, 63))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Query", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jRadioButton1.setText("Whole Region");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Range Query");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Point Query");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Find Photos");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setText("Find Photographers");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jRadioButton5))
        );

        jButton1.setText("         Submit             Query");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextField1.setColumns(20);
        jTextField1.setText(" Your Submitted Query Should Be Displayed Here..........");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/map.JPG"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });

        jTextField3.setText("               Current mouse Location");

        jTextField4.setText("MOUSE_LOCATION_Y:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1331, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jTextField4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>                        
    
    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {                                   
        jTextField3.setText(""+evt.getX());
        jTextField4.setText(""+evt.getY());
        
    }                                  

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       clear();
        jLabel3.repaint();
    
    }                                          

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    clear();
        jLabel3.repaint();
    }                                          

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
      clear();
       jLabel3.repaint();
    }                                          

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
     clear();
       jLabel3.repaint();
     
    }                                             

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {                                           
      
        
    }                                          

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {                                     
      if(jRadioButton2.isSelected())
        {
            if(evt.getButton() == MouseEvent.BUTTON3)
            {
                if(lastx<0 && lasty <0)
                {
                    JOptionPane.showMessageDialog(null,"First select the points");
                }
                else if(noofpoints < 3 )
                    JOptionPane.showMessageDialog(null,"Please select atleast three points");
                else
                {
                    regionClosed=1;
                    Graphics g=jLabel3.getGraphics();
                    g.setColor(Color.red);
                    g.drawLine(lastx,lasty,firstx,firsty);
                    arg+=firstx+","+firsty;
                }    
            }
            if(evt.getButton() == MouseEvent.BUTTON1)
            {
                noofpoints++;
                if(lastx<0 && lasty <0)
                {
                    firstx=evt.getX();
                    firsty=evt.getY();
                    lastx=evt.getX();
                    lasty=evt.getY();
                    arg+=firstx+","+firsty+",";
                }
                else
                {
                    Graphics g=jLabel3.getGraphics();
                    g.setColor(Color.red);
                    g.drawLine(lastx,lasty,evt.getX(),evt.getY());
                    lastx=evt.getX();
                    lasty=evt.getY();
                    arg+=lastx+","+lasty+",";
                }    
            }
        }
    
          if(jRadioButton3.isSelected())
        {
            clear();
            mouseX=evt.getX();
            mouseY=evt.getY();
            pointQuery=1;
            paintComponentPoint(jLabel3.getGraphics(),Color.red,mouseX,mouseY);
        }
       
      if(jRadioButton4.isSelected())
            {
                 Graphics g1 = jLabel3.getGraphics();
            g1.setColor(Color.RED);
            p.addPoint(evt.getX(),evt.getY());
           
            if(evt.getButton() == MouseEvent.BUTTON1)
            { clear();
                pointQuery=1;
                mouseX=evt.getX();
                mouseY=evt.getY();
                paintComponentSquarePoint(jLabel3.getGraphics(),Color.red,mouseX,mouseY);
                String arg=mouseX+","+mouseY;
               String query="select photographerlocation from PHOTOGRAPHERI p where mdsys.sdo_nn(p.photographerlocation, MDSYS.SDO_GEOMETRY(2001,null,MDSYS.SDO_POINT_TYPE("+arg+",null),null,null),'sdo_num_res=1') = 'TRUE'";
                jTextField1.setText("Query "+queryCount+". "+query+"\n");
                paintComponentPHOTOGRAPHERI(jLabel3.getGraphics(), Color.red, query);
                 
               if(count==1)
              {
                  
                      firstx=evt.getX();
                    firsty=evt.getY();
                         
                        count++;
               }
               if(count>=2)
                    {  
                       
                       
                         lastx=evt.getX();
                    lasty=evt.getY();
                         
                         count++;
                         
                         
                         if(count==5)
                         {
                           xfirst=firstx;
                           yfirst=firsty;
                         }
                         
                         if(count>=4)
                         {
                             p.addPoint(evt.getX(),evt.getY());
                         }
                         if(count>=5)
                         {
                         p.addPoint(evt.getX(),evt.getY());
                         g1.drawLine(firstx, firsty, lastx, lasty);
                         }
                         firstx=lastx;
                         firsty=lasty;
                    }}
            
            if(evt.getButton() == MouseEvent.BUTTON3)
            {
               firstx= evt.getX();
                  firsty= evt.getY();

                  
                  g1.drawLine(lastx, lasty, firstx, firsty);
                  g1.drawLine(firstx, firsty, xfirst, yfirst);
                
                   g1.setColor(Color.red);
    
            }
} 
      if(jRadioButton5.isSelected())
            {
                
                clear();
                pointQuery=1;
                mouseX=evt.getX();
                mouseY=evt.getY();
                paintComponentSquarePoint(jLabel3.getGraphics(),Color.red,mouseX,mouseY);
                String arg=mouseX+","+mouseY;
                String query="select building_Shape from Buildings b where mdsys.sdo_nn(b.building_Shape, MDSYS.SDO_GEOMETRY(2001,null,MDSYS.SDO_POINT_TYPE("+arg+",null),null,null),'sdo_num_res=1') = 'TRUE'";
                jTextField1.setText("Query "+queryCount+". "+query+"\n");
                paintComponentBuildings(jLabel3.getGraphics(), Color.red, query);
            }
    }                                    

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      

       if(!jRadioButton1.isSelected() && !jRadioButton2.isSelected() && !jRadioButton3.isSelected() && !jRadioButton4.isSelected() && !jRadioButton5.isSelected())
           JOptionPane.showMessageDialog(null,"Please select query");
        else{
            queryCount++;
            
       if(jRadioButton1.isSelected())
        {
           if(!jCheckBox1.isSelected() && !jCheckBox2.isSelected() && !jCheckBox3.isSelected())
               JOptionPane.showMessageDialog(null,"Please select feature");
           else{
           if(jCheckBox1.isSelected()){
            String query= "select building_Shape from Buildings";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentBuildings(jLabel3.getGraphics(),Color.yellow,query);
            }
           if(jCheckBox2.isSelected()){
                
           String query= "select photo_location from PHOTOI";
           jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentPHOTOI(jLabel3.getGraphics(),Color.blue,query);
            }
           if(jCheckBox3.isSelected())
            {
            String query="select photographerlocation from PHOTOGRAPHERI";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentPHOTOGRAPHERI(jLabel3.getGraphics(),Color.green,query);
            }
          }
       }
       
       else if(jRadioButton2.isSelected())
       {
            
           if(!jCheckBox1.isSelected() && !jCheckBox2.isSelected() && !jCheckBox3.isSelected())
           {JOptionPane.showMessageDialog(null,"Please select feature");}
           
           else if(noofpoints<3)
          {   
               clear();
                jLabel3.repaint();
                JOptionPane.showMessageDialog(null,"Please select a region on Map");
            }
           else if(regionClosed==0)
           {
                clear();
                jLabel3.repaint();
                JOptionPane.showMessageDialog(null,"You din't close the region properly. \n Please select region again.");
            }  
          else  if(jCheckBox2.isSelected()){
                   
            String query="select photo_location from PHOTOI p where mdsys.sdo_relate(p.photo_location, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'mask=TOUCH+INSIDE') = 'TRUE'";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentPHOTOI(jLabel3.getGraphics(),Color.blue,query);
            System.out.println("Photo inside");
            }
          else  if(jCheckBox1.isSelected()){
             
            String query="select building_Shape from Buildings b where mdsys.sdo_relate(b.building_Shape, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'mask=ANYINTERACT') = 'TRUE'";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
          
            paintComponentBuildings(jLabel3.getGraphics(),Color.yellow,query);
            System.out.println("Building inside");
            }
          else if(jCheckBox3.isSelected()){
                
            String query="select photographerlocation from PHOTOGRAPHERI P where mdsys.sdo_relate(P.photographerlocation, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'mask=TOUCH+INSIDE') = 'TRUE'";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentPHOTOGRAPHERI(jLabel3.getGraphics(),Color.green,query);
           System.out.println("Photographer inside");
            }
            }
            
    
       else  if(jRadioButton3.isSelected())
        {
             if(pointQuery==0)
            { 
                JOptionPane.showMessageDialog(null,"Please select a point on Map");
            }
            else{
                paintComponentPoint(jLabel3.getGraphics(),Color.red,mouseX,mouseY);
            if(!jCheckBox1.isSelected() && !jCheckBox2.isSelected() && !jCheckBox3.isSelected())
                JOptionPane.showMessageDialog(null,"Please select feature");
            else{
            int r=100,x=mouseX,y=mouseY;
            String arg=""+x+","+(y+r)+","+(x+r)+","+y+","+x+","+(y-r);
            if(jCheckBox3.isSelected())
            {
            
            String query="select building_Shape,building_id from Buildings b where b.building_id in (select building_id from Buildings b where mdsys.sdo_relate(b.building_Shape, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'mask=ANYINTERACT') = 'TRUE') and mdsys.sdo_nn(b.building_Shape, MDSYS.SDO_GEOMETRY(2001,null,MDSYS.SDO_POINT_TYPE("+mouseX+","+mouseY+",null),null,null),'sdo_num_res=1') = 'TRUE'";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentBuildings(jLabel3.getGraphics(),Color.yellow,query);
            
            String nearestID=db.getID(query);
            
            query="select building_Shape from Buildings b where building_id not like '"+nearestID+"' and mdsys.sdo_relate(b.building_Shape, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'mask=ANYINTERACT') = 'TRUE'";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentBuildings(jLabel3.getGraphics(),Color.green,query);
            }
            if(jCheckBox2.isSelected())
            {
            String query="select photo_location,photo_id from PHOTOI p where p.photo_id in (select photo_id from PHOTOI p where mdsys.sdo_relate(p.photo_location, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'mask=ANYINTERACT') = 'TRUE') and mdsys.sdo_nn(p.photo_location, MDSYS.SDO_GEOMETRY(2001,null,MDSYS.SDO_POINT_TYPE("+mouseX+","+mouseY+",null),null,null),'sdo_num_res=1') = 'TRUE'";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentPHOTOI(jLabel3.getGraphics(),Color.yellow,query);
            
            String nearestID=db.getID(query);
            
            query="select photo_location from PHOTOI p where photo_id not like '"+nearestID+"' and mdsys.sdo_relate(p.photo_location, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'mask=ANYINTERACT') = 'TRUE'";    
           jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentPHOTOI(jLabel3.getGraphics(),Color.green,query);
            }
            if(jCheckBox3.isSelected())
            {
            String query="select photographerlocation,photographer_id from PHOTOGRAPHERI p where p.photographer_id in (select photographer_id from PHOTOGRAPHERI p where mdsys.sdo_relate(p.photographerlocation, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'mask=ANYINTERACT') = 'TRUE') and mdsys.sdo_nn(p.photographerlocation, MDSYS.SDO_GEOMETRY(2001,null,MDSYS.SDO_POINT_TYPE("+mouseX+","+mouseY+",null),null,null),'sdo_num_res=1') = 'TRUE'";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentPHOTOGRAPHERI(jLabel3.getGraphics(),Color.yellow,query);
            
            String nearestID=db.getID(query);
           query="select photographerlocation from PHOTOGRAPHERI p where photographer_id not like '"+nearestID+"' and  mdsys.sdo_relate(p.photographerlocation, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'mask=ANYINTERACT') = 'TRUE'";    
           jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentPHOTOGRAPHERI(jLabel3.getGraphics(),Color.green,query);
            }
            }
            }
            }
        
             if(jRadioButton4.isSelected())
        {  mouseX=evt.getX();
               mouseY=evt.getY();
             if(pointQuery==0)
            { 
               JOptionPane.showMessageDialog(null,"Please select a point on Map");
           }
            else{
            
            String arg=mouseX+","+mouseY;
            String query="SELECT p.photo_location FROM PHOTOI p where MDSYS.SDO_FILTER(p.photo_location, MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY("+arg+"))) = 'TRUE' AND p.photographer_id IN(select ph.photographer_id from PHOTOGRAPHERI ph where mdsys.sdo_nn(ph.photographerlocation, MDSYS.SDO_GEOMETRY(2001,null, MDSYS.SDO_POINT_TYPE("+arg+",null),null,null),'sdo_num_res=1') = 'TRUE')";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
            paintComponentPHOTOI(jLabel3.getGraphics(),Color.red,query);}
       }
           
        if(jRadioButton5.isSelected())
        {
            String arg=mouseX+","+mouseY;
            String query="SELECT photo_location FROM PHOTOI p WHERE SDO_WITHIN_DISTANCE(p.photo_location,MDSYS.SDO_GEOMETRY(2003,null,null,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY("+arg+")),'distance=80') = 'TRUE'";
            jTextField1.setText("Query "+queryCount+". "+query+"\n");
           paintComponentPHOTOI(jLabel3.getGraphics(),Color.blue,query);
         
      }
 
       }
    }                                     
   
    
           
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        clear();
        jLabel3.repaint();
      
    }                                             

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
         clear();
       jLabel3.repaint();
    }                                             

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                              
      
     
             String query= "select photo_location from PHOTOI";
            paintComponentPHOTOI(jLabel3.getGraphics(),Color.blue,query);
          String query2="select photographerlocation from PHOTOGRAPHERI";
            paintComponentPHOTOGRAPHERI(jLabel3.getGraphics(),Color.green,query2); 
            String query1= "select building_Shape from Buildings";
            paintComponentBuildings(jLabel3.getGraphics(),Color.yellow,query1);
    }                                             

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                              
           String query= "select photo_location from PHOTOI";
            paintComponentPHOTOI(jLabel3.getGraphics(),Color.blue,query);
          String query2="select photographerlocation from PHOTOGRAPHERI";
            paintComponentPHOTOGRAPHERI(jLabel3.getGraphics(),Color.green,query2); 
             String query1= "select building_Shape from Buildings";
            paintComponentBuildings(jLabel3.getGraphics(),Color.yellow,query1);
    }                                             
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       try
      {
          Class.forName("oracle.jdbc.OracleDriver");
          //Class.forName("com.mysql.jdbc.Driver");
          String host="dagobah.engr.scu.edu";
          String dbName="DB11G";
         int port=1521;
          String oracleURL = "jdbc:oracle:thin:@" +host+ ":" +port+ ":" +dbName;
          //String mysqlURL="jdbc:mysql://" +host+ ":" +port+ "/" +dbName;
         String username="asahu";
          String password="SONIAJAZZ91";
          Connection connection = DriverManager.getConnection(oracleURL,username,password);
          //Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ora11g","asahu","SONIAJAZZ91");
          System.out.println("Connection Successful");
          //Statement st=connection.createStatement();
         //int i=st.executeUpdate("insert into employee " + "values(102,'Abhilasha',500000)");
          //String select="select * from Buildings";
          //Statement st= connection.createStatement();
        //ResultSet rs=st.executeQuery("SELECT * from Buildings");
       // System.out.println("ResultSet Successful");
        //ResultSetMetaData rsmd=rs.getMetaData();
        //System.out.println("ResultSetMetaData successful");
          
          //while(rs.next())
          
          
              
                  //System.out.print(rs.getString("building_ID")+ "\t"+rs.getString("building_name")+ "\t" + rs.getString("building_Shape"));
           
                      
              
        
          //st.executeQuery(select);
      
    
        //rs.close();
          //st.close();
          connection.close();}
   
          catch(Exception e)
          {
              System.out.println(e);}
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration                   

}
