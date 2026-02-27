package P1;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class TIENDACARROS extends javax.swing.JFrame {
    
    
    
    private java.util.Set<String> marcasSeleccionadas = new java.util.HashSet<>();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TIENDACARROS.class.getName());

    
    public TIENDACARROS() {
        initComponents();  
        marcasSeleccionadas.add("Ford");
        marcasSeleccionadas.add("Mercedes");
        marcasSeleccionadas.add("Ferrari");
        this.setLocationRelativeTo(null);
        
        crearMenuDerecha();  
        ponerIconoMenuEnPanelDerecho();
        
        activarPopupEnPanelDerecho();   //mmetodo activado 
        centrarEnPanel(PanelMustang, LblMustang);
        centrarEnPanel(PanelShelby, LblShelby);
        centrarEnPanel(PanelMercedes1, LblMercedes1);
        centrarEnPanel(PanelMercedes2, LblMercedes2);
        centrarEnPanel(PanelFerrari1, LblFerrari1);
        centrarEnPanel(PanelFerrari2, LblFerrari2);
        configurarScrollGaleria();
        cargarMiniaturas();
       
    }
    
    
    
private void configurarScrollGaleria() {
    // USAR el panel que ya existe dentro del scroll del diseñador: jPanel3
    jPanel3.removeAll();
    jPanel3.setLayout(new java.awt.GridLayout(0, 2, 30, 30));

    jPanel3.add(PanelMustang);
    jPanel3.add(PanelShelby);
    jPanel3.add(PanelMercedes1);
    jPanel3.add(PanelMercedes2);
    jPanel3.add(PanelFerrari1);
    jPanel3.add(PanelFerrari2);

    jPanel3.revalidate();
    jPanel3.repaint();
    
    jPanel3.setPreferredSize(new java.awt.Dimension(0, 1000));

    // Asegurar políticas de scroll en el scroll que SÍ está en el layout
    scrollGaleria.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollGaleria.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
}


    private void centrarEnPanel(javax.swing.JPanel panel, javax.swing.JLabel label) {
    panel.removeAll();
    panel.setLayout(new java.awt.BorderLayout());
    label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    panel.add(label, java.awt.BorderLayout.CENTER);
}
    
   private void mostrarImagenGrande(String ruta) {

     
    int anchoMax = LabelLogo.getWidth();   // tamaño máximo deseado
    int altoMax = LabelLogo.getWidth();
    
    if(anchoMax <= 0) anchoMax = 500;
    if(altoMax <= 0) altoMax = 500;
    
    LabelLogo.setIcon(escalarImagen(ruta, anchoMax, altoMax));
    LabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelLogo.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

   
}

    
    private void cargarMiniaturas() {
    
    PanelMustang.setPreferredSize(new java.awt.Dimension(300, 150)); 
    configurarLabel(LblMustang, "/imagenes/mustang.jpg", 342, 192);
    
    PanelShelby.setPreferredSize(new java.awt.Dimension(300, 150));
    configurarLabel(LblShelby, "/imagenes/shelby.jpg", 390, 192);

    
    PanelMercedes1.setPreferredSize(new java.awt.Dimension(300, 150));
    configurarLabel(LblMercedes1, "/imagenes/mercedes1.jpg", 342, 193);

    
     PanelMercedes2.setPreferredSize(new java.awt.Dimension(300, 150));
     configurarLabel(LblMercedes2, "/imagenes/mercedes2.jpg", 374, 250);

    
    PanelFerrari1.setPreferredSize(new java.awt.Dimension(300, 150));
    configurarLabel(LblFerrari1, "/imagenes/ferrari1.jpg", 342, 195);

    
    PanelFerrari2.setPreferredSize(new java.awt.Dimension(300, 150));
        configurarLabel(LblFerrari2, "/imagenes/ferrari2.jpg", 342, 195);

    
    
    this.revalidate();
    this.repaint();
        /*int anchoFijo = 374; 
        int altoFijo = 193;
    
    // Creamos un arreglo con tus Labels para limpiarlos todos de una vez
    javax.swing.JLabel[] misLabels = {LblMustang, LblShelby, LblMercedes1, LblMercedes2, LblFerrari1, LblFerrari2};
    String[] rutas = {"/imagenes/mustang.jpg", "/imagenes/shelby.jpg", "/imagenes/mercedes1.jpg", 
                      "/imagenes/mercedes2.jpg", "/imagenes/ferrari1.jpg", "/imagenes/ferrari2.jpg"};

    for (int i = 0; i < misLabels.length; i++) {
        if (misLabels[i] != null) {
            misLabels[i].setText(""); // BORRA el texto "jLabel7"
            misLabels[i].setIcon(escalarImagen(rutas[i], anchoFijo, altoFijo));
            misLabels[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);*/
        }
    
    private void configurarLabel(javax.swing.JLabel label, String ruta, int w, int h) {
        if (label != null) {
            label.setText(""); // Borra el "jLabelX"
            label.setIcon(escalarImagen(ruta, w, h));
            label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        }
    }
    
        
        
    

    
    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
try {
        // Buscamos el archivo en los recursos del proyecto
        java.net.URL imgURL = getClass().getResource(ruta);
        if (imgURL != null) {
            ImageIcon iconoOriginal = new ImageIcon(imgURL);
            Image imagen = iconoOriginal.getImage();
            
            // Redimensionamos a los valores exactos que pasamos por parámetro
            Image imagenEscalada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            
            return new ImageIcon(imagenEscalada);
        } else {
            System.err.println("No se encontró el archivo en: " + ruta);
        }
    } catch (Exception e) {
        System.err.println("Error al procesar la imagen: " + e.getMessage());
    }
    return null;
        
    
}
    
    private void ponerIconoMenuEnPanelDerecho() {
    // Limpia el panel y pon layout simple
    panelMenu.removeAll();
    panelMenu.setLayout(new java.awt.BorderLayout());

    lblMenu = new javax.swing.JLabel();
    lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblMenu.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    lblMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // manita

    // Ajusta tamaño del icono (ej: 32x32 o 40x40)
    ImageIcon icon = escalarImagen("/imagenes/menu.png", 36, 36);
    
    lblMenu.setIcon(icon);

    panelMenu.add(lblMenu, java.awt.BorderLayout.CENTER);

    panelMenu.revalidate();
    panelMenu.repaint();
}
    private void mostrarInfoCarro(
        String marcaModelo,
        String anio,
        String motor,
        String ceroACien,
        String velMax,
        String precio,
        String color,
        String descripcion,
        String rutaImagen
) {
    ImageIcon icon = escalarImagen(rutaImagen, 520, 290);

    javax.swing.JLabel lblImg = new javax.swing.JLabel(icon);
    lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    String texto =
            "Marca / Modelo: " + marcaModelo + "\n" +
            "Año: " + anio + "\n" +
            "Motor: " + motor + "\n" +
            "0–100 km/h: " + ceroACien + "\n" +
            "Vel. Máx: " + velMax + "\n" +
            "Precio: " + precio + "\n" +
            "Color: " + color + "\n\n" +
            "Descripción:\n" + descripcion;

    javax.swing.JTextArea area = new javax.swing.JTextArea(texto);
    area.setEditable(false);
    area.setLineWrap(true);
    area.setWrapStyleWord(true);
    area.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 14));

    javax.swing.JScrollPane sp = new javax.swing.JScrollPane(area);
    sp.setBorder(null);
    sp.setPreferredSize(new java.awt.Dimension(520, 220));

    javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.BorderLayout(10, 10));
    panel.add(lblImg, java.awt.BorderLayout.NORTH);
    panel.add(sp, java.awt.BorderLayout.CENTER);

    javax.swing.JOptionPane.showMessageDialog(
            this,
            panel,
            marcaModelo,
            javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
}

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        jPopupMenu6 = new javax.swing.JPopupMenu();
        jPopupMenu7 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        LabelLogo = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        scrollGaleria = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        PanelMustang = new javax.swing.JPanel();
        LblMustang = new javax.swing.JLabel();
        PanelShelby = new javax.swing.JPanel();
        LblShelby = new javax.swing.JLabel();
        PanelMercedes1 = new javax.swing.JPanel();
        LblMercedes1 = new javax.swing.JLabel();
        PanelMercedes2 = new javax.swing.JPanel();
        LblMercedes2 = new javax.swing.JLabel();
        PanelFerrari1 = new javax.swing.JPanel();
        LblFerrari1 = new javax.swing.JLabel();
        PanelFerrari2 = new javax.swing.JPanel();
        LblFerrari2 = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        LabelLogo.setFont(new java.awt.Font("Phosphate", 0, 48)); // NOI18N
        LabelLogo.setForeground(new java.awt.Color(204, 0, 0));
        LabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLogo.setText("CAR´S HOUSE");

        panelMenu.setToolTipText("");
        panelMenu.setComponentPopupMenu(jPopupMenu7);
        panelMenu.setLayout(new java.awt.BorderLayout());
        panelMenu.add(lblMenu, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setLayout(new java.awt.GridLayout(0, 2, 30, 30));

        PanelMustang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelMustang.setLayout(new java.awt.GridBagLayout());

        LblMustang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMustang.setPreferredSize(new java.awt.Dimension(500, 350));
        LblMustang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblMustangMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 18, 13);
        PanelMustang.add(LblMustang, gridBagConstraints);

        PanelShelby.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelShelby.setLayout(new java.awt.GridBagLayout());

        LblShelby.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblShelby.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblShelbyMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 41, 48);
        PanelShelby.add(LblShelby, gridBagConstraints);

        PanelMustang.add(PanelShelby, new java.awt.GridBagConstraints());

        PanelMercedes1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelMercedes1.setLayout(new java.awt.GridBagLayout());

        LblMercedes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMercedes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblMercedes1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 62, 30);
        PanelMercedes1.add(LblMercedes1, gridBagConstraints);

        PanelMustang.add(PanelMercedes1, new java.awt.GridBagConstraints());

        PanelMercedes2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelMercedes2.setComponentPopupMenu(jPopupMenu4);
        PanelMercedes2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelMercedes2.setLayout(new java.awt.GridBagLayout());

        LblMercedes2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMercedes2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblMercedes2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 40, 63);
        PanelMercedes2.add(LblMercedes2, gridBagConstraints);

        PanelMustang.add(PanelMercedes2, new java.awt.GridBagConstraints());

        PanelFerrari1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelFerrari1.setLayout(new java.awt.GridBagLayout());

        LblFerrari1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblFerrari1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblFerrari1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 51, 43);
        PanelFerrari1.add(LblFerrari1, gridBagConstraints);

        PanelMustang.add(PanelFerrari1, new java.awt.GridBagConstraints());

        PanelFerrari2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelFerrari2.setLayout(new java.awt.GridBagLayout());

        LblFerrari2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblFerrari2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblFerrari2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 58, 48);
        PanelFerrari2.add(LblFerrari2, gridBagConstraints);

        PanelMustang.add(PanelFerrari2, new java.awt.GridBagConstraints());

        jPanel3.add(PanelMustang);

        scrollGaleria.setViewportView(jPanel3);

        btnVender.setBackground(new java.awt.Color(255, 0, 0));
        btnVender.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        btnVender.setForeground(new java.awt.Color(255, 255, 255));
        btnVender.setText("VENDER");
        btnVender.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVender.addActionListener(this::btnVenderActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                        .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private javax.swing.JPopupMenu menuDerecha;
    private String filtroColorActual = "Todos";
    
    // Estado del menú
private String filtroMarcaActual = "Todos";
private String ordenActual = "Ninguno";

// Refresca el contenido del grid (jPanel3) según filtro/orden
private void refrescarGaleria() {
     jPanel3.removeAll();
    jPanel3.setLayout(new java.awt.GridLayout(0, 2, 30, 30));

    java.util.List<javax.swing.JPanel> items = java.util.List.of(
            PanelMustang, PanelShelby, PanelMercedes1, PanelMercedes2, PanelFerrari1, PanelFerrari2
    );

    java.util.List<javax.swing.JPanel> filtrados = new java.util.ArrayList<>();

    for (javax.swing.JPanel p : items) {

        // -------- Marca --------
        String marca =
                (p == PanelMustang || p == PanelShelby) ? "Ford" :
                (p == PanelMercedes1 || p == PanelMercedes2) ? "Mercedes" :
                "Ferrari";

        if (!marcasSeleccionadas.contains(marca)) continue;

        // -------- Color --------
        String color =
                (p == PanelFerrari1 || p == PanelFerrari2) ? "Rojo" :
                (p == PanelMercedes2) ? "Naranja" :
                (p == PanelShelby) ? "Azul" :
                "Negro"; // Mustang y Mercedes1

        
        if (!"Todos".equalsIgnoreCase(filtroColorActual) && !color.equalsIgnoreCase(filtroColorActual)) {
            continue;
        }

        filtrados.add(p);
    }

    
    if (!"Ninguno".equals(ordenActual)) {
        java.util.Collections.reverse(filtrados);
    }

    for (javax.swing.JPanel p : filtrados) {
        jPanel3.add(p);
    }

    jPanel3.revalidate();
    jPanel3.repaint();

    //  Subir scroll ARRIBA sin que brinque
    javax.swing.SwingUtilities.invokeLater(() -> {
        scrollGaleria.getVerticalScrollBar().setValue(0);
    });

}


private void crearMenuDerecha() {
    menuDerecha = new javax.swing.JPopupMenu();
    javax.swing.JMenu menuFiltrar = new javax.swing.JMenu("Filtrar por marca");

    javax.swing.JMenuItem itemColor = new javax.swing.JMenuItem("Filtrar por color");
    itemColor.addActionListener(e -> mostrarFiltroColorRadio());
    menuDerecha.add(itemColor);

    javax.swing.JMenuItem itemSalir = new javax.swing.JMenuItem("Salir");
    itemSalir.addActionListener(e -> System.exit(0));
    menuDerecha.add(itemSalir);

    // ... y luego agregas el menuFiltrar
    menuDerecha.addSeparator();
    menuDerecha.add(menuFiltrar);

    

javax.swing.JCheckBoxMenuItem chkFord = new javax.swing.JCheckBoxMenuItem("Ford", marcasSeleccionadas.contains("Ford"));
javax.swing.JCheckBoxMenuItem chkMercedes = new javax.swing.JCheckBoxMenuItem("Mercedes", marcasSeleccionadas.contains("Mercedes"));
javax.swing.JCheckBoxMenuItem chkFerrari = new javax.swing.JCheckBoxMenuItem("Ferrari", marcasSeleccionadas.contains("Ferrari"));

javax.swing.JMenuItem itemTodos = new javax.swing.JMenuItem("Mostrar todos");

// Acción: marcar todos
itemTodos.addActionListener(e -> {
    marcasSeleccionadas.clear();
    marcasSeleccionadas.add("Ford");
    marcasSeleccionadas.add("Mercedes");
    marcasSeleccionadas.add("Ferrari");

    chkFord.setSelected(true);
    chkMercedes.setSelected(true);
    chkFerrari.setSelected(true);

    refrescarGaleria();
});

// Acción: cuando cambie cualquier check
java.awt.event.ItemListener il = ev -> {
    marcasSeleccionadas.clear();
    if (chkFord.isSelected()) marcasSeleccionadas.add("Ford");
    if (chkMercedes.isSelected()) marcasSeleccionadas.add("Mercedes");
    if (chkFerrari.isSelected()) marcasSeleccionadas.add("Ferrari");

    // Si dejan todo desmarcado, mejor volvemos a "todos"
    if (marcasSeleccionadas.isEmpty()) {
        marcasSeleccionadas.add("Ford");
        marcasSeleccionadas.add("Mercedes");
        marcasSeleccionadas.add("Ferrari");
        chkFord.setSelected(true);
        chkMercedes.setSelected(true);
        chkFerrari.setSelected(true);
    }

    refrescarGaleria();
};

chkFord.addItemListener(il);
chkMercedes.addItemListener(il);
chkFerrari.addItemListener(il);

menuFiltrar.add(itemTodos);
menuFiltrar.addSeparator();
menuFiltrar.add(chkFord);
menuFiltrar.add(chkMercedes);
menuFiltrar.add(chkFerrari);

 menuDerecha.add(menuFiltrar);

    
   
}



private void mostrarFiltroColorRadio() {
    String[] colores = {"Todos", "Negro", "Azul", "Naranja", "Rojo"};

    javax.swing.JPanel panel = new javax.swing.JPanel();
    panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));

    javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();

    final javax.swing.JRadioButton[] seleccionado = new javax.swing.JRadioButton[1];

    for (String c : colores) {
        javax.swing.JRadioButton rb = new javax.swing.JRadioButton(c);
        rb.setSelected(c.equalsIgnoreCase(filtroColorActual));
        group.add(rb);
        panel.add(rb);

        if (rb.isSelected()) seleccionado[0] = rb;
    }

    int res = javax.swing.JOptionPane.showConfirmDialog(
            this,
            panel,
            "Filtrar por color",
            javax.swing.JOptionPane.OK_CANCEL_OPTION,
            javax.swing.JOptionPane.PLAIN_MESSAGE
    );

    if (res == javax.swing.JOptionPane.OK_OPTION) {
        // buscar cuál quedó seleccionado
        for (java.awt.Component comp : panel.getComponents()) {
            if (comp instanceof javax.swing.JRadioButton rb && rb.isSelected()) {
                filtroColorActual = rb.getText();
                break;
            }
        }
        refrescarGaleria(); // aquí aplicas el filtro
    }
}


  

private void activarPopupEnPanelDerecho() {
    // Click derecho (Windows/Linux) y también click normal si quieres
    /*if (jPopupMenu1 == null) {
        jPopupMenu1 = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem itemVender = new javax.swing.JMenuItem("Vender Carro");
        jPopupMenu1.add(itemVender);
    }*/
        java.awt.event.MouseAdapter listener = new java.awt.event.MouseAdapter() {

        private void showPopup(java.awt.event.MouseEvent e) {
            if (menuDerecha == null) return;

            // para Mac a veces funciona mejor así:
            boolean rightClick = javax.swing.SwingUtilities.isRightMouseButton(e);
            boolean popup = e.isPopupTrigger();

            if (popup || rightClick) {
                menuDerecha.show(e.getComponent(), e.getX(), e.getY());
            }
        }

        @Override public void mousePressed(java.awt.event.MouseEvent e) { showPopup(e); }
        @Override public void mouseReleased(java.awt.event.MouseEvent e) { showPopup(e); }

        @Override public void mouseClicked(java.awt.event.MouseEvent e) {
            // click izquierdo también abre el menú (opcional)
            if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) {
                menuDerecha.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    };

    // ✅ pon el listener en el panel Y en el label (para que funcione aunque des click en el icono)
    panelMenu.addMouseListener(listener);
    lblMenu.addMouseListener(listener);
       
}

    private void LblMustangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblMustangMouseClicked
        
        mostrarInfoCarro(
        "Ford Mustang",
        "2020",
        "V8 5.0L",
        "4.2 s",
        "250 km/h",
        "$ 950,000 MXN",
        "Negro",
        "Coupé deportivo con enfoque en potencia y estilo clásico.",
        "/imagenes/mustang.jpg"
    );
    }//GEN-LAST:event_LblMustangMouseClicked

    private void LblShelbyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblShelbyMouseClicked
        mostrarInfoCarro(
        "Ford Mustang Shelby GT500",
        "2021",
        "V8 Supercargado 5.2L",
        "3.5 s",
        "290 km/h",
        "$ 1,900,000 MXN",
        "Azul con franjas",
        "Versión de alto desempeño, preparada para pista con gran aceleración.",
        "/imagenes/shelby.jpg"
    );
    }//GEN-LAST:event_LblShelbyMouseClicked

    private void LblMercedes1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblMercedes1MouseClicked
        mostrarInfoCarro(
        "Mercedes-AMG ONE",
        "2020",
        "V8 Biturbo",
        "3.7 s",
        "315 km/h",
        "$ 2,500,000 MXN",
        "Negro",
        "Superdeportivo de lujo con aerodinámica agresiva y enfoque track.",
        "/imagenes/mercedes1.jpg"
    );
    }//GEN-LAST:event_LblMercedes1MouseClicked

    private void LblMercedes2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblMercedes2MouseClicked
         mostrarInfoCarro(
        "Mercedes-AMG GT Black Series",
        "2021",
        "V8 Biturbo",
        "3.2 s",
        "320 km/h",
        "$ 3,200,000 MXN",
        "Naranja",
        "Diseño radical, alto desempeño y conducción enfocada en pista.",
        "/imagenes/mercedes2.jpg"
    );
    }//GEN-LAST:event_LblMercedes2MouseClicked

    private void LblFerrari1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblFerrari1MouseClicked
         mostrarInfoCarro(
        "Ferrari Sf90 (Modelo 1)",
        "2019",
        "V8 Turbo",
        "3.0 s",
        "340 km/h",
        "$ 6,800,000 MXN",
        "Rojo",
        "Supercar italiano: balance entre lujo, velocidad y precisión.",
        "/imagenes/ferrari1.jpg"
    );
    }//GEN-LAST:event_LblFerrari1MouseClicked

    private void LblFerrari2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblFerrari2MouseClicked
         mostrarInfoCarro(
        "Ferrari (Modelo 2)",
        "2020",
        "V8 Turbo",
        "2.9 s",
        "350 km/h",
        "$ 7,500,000 MXN",
        "Rojo",
        "Edición enfocada en rendimiento, ligera y con respuesta inmediata.",
        "/imagenes/ferrari2.jpg"
    );
    }//GEN-LAST:event_LblFerrari2MouseClicked
    
   
    
   
    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
       
        VenderV2 venta = new VenderV2();
        venta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVenderActionPerformed

   
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TIENDACARROS().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LblFerrari1;
    private javax.swing.JLabel LblFerrari2;
    private javax.swing.JLabel LblMercedes1;
    private javax.swing.JLabel LblMercedes2;
    private javax.swing.JLabel LblMustang;
    private javax.swing.JLabel LblShelby;
    private javax.swing.JPanel PanelFerrari1;
    private javax.swing.JPanel PanelFerrari2;
    private javax.swing.JPanel PanelMercedes1;
    private javax.swing.JPanel PanelMercedes2;
    private javax.swing.JPanel PanelMustang;
    private javax.swing.JPanel PanelShelby;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JPopupMenu jPopupMenu6;
    private javax.swing.JPopupMenu jPopupMenu7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JScrollPane scrollGaleria;
    // End of variables declaration//GEN-END:variables
}