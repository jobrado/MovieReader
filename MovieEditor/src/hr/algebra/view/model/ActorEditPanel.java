/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Actor;
import hr.algebra.model.Movie;
import hr.algebra.model.MovieTransferable;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.FormUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import hr.algebra.view.model.table.ActorTableModel;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Jo
 */
public class ActorEditPanel extends javax.swing.JPanel {

    /**
     * Creates new form ActorEditPanel
     */
    public ActorEditPanel() {
        initComponents();
    }

    private List<JTextComponent> fields;
    private List<JLabel> labels;
    private static final String DIR = "assets";
    private Repository actorRepository;
    private Repository movieRepository;
    private ActorTableModel actorTableModel;
    private Actor selectedActor;
    private final DefaultListModel<Movie> allMoviesModel = new DefaultListModel<>();
    private final DefaultListModel<Movie> movieModel = new DefaultListModel<>();

    private List<Movie> allMovies = new ArrayList<>();
    private final List<Movie> movies = new ArrayList<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbActorTable = new javax.swing.JTable();
        lblNameOfActor = new javax.swing.JLabel();
        btnActorDelete = new javax.swing.JButton();
        lblErrorActorChoose = new javax.swing.JLabel();
        btnActorChoose = new javax.swing.JButton();
        tfActorPicturePath = new javax.swing.JTextField();
        btnActorUpdate = new javax.swing.JButton();
        btnActorAdd = new javax.swing.JButton();
        tfActorFirstName = new javax.swing.JTextField();
        lblErrorActorIcon = new javax.swing.JLabel();
        lblErrorActorFirstName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblErrorActorMovies = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsMovieList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsAllMoviesList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnClearList = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(230, 230, 249));
        setMinimumSize(new java.awt.Dimension(1192, 768));
        setPreferredSize(new java.awt.Dimension(1192, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/assets/no_image.png"))); // NOI18N
        lblIcon.setRequestFocusEnabled(false);

        tbActorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbActorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbActorTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbActorTable);

        lblNameOfActor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNameOfActor.setText("IME I PREZIME GLUMCA");

        btnActorDelete.setBackground(new java.awt.Color(255, 153, 153));
        btnActorDelete.setText("Delete");
        btnActorDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActorDeleteActionPerformed(evt);
            }
        });

        lblErrorActorChoose.setForeground(new java.awt.Color(255, 0, 51));

        btnActorChoose.setText("Choose");
        btnActorChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActorChooseActionPerformed(evt);
            }
        });

        btnActorUpdate.setText("Update");
        btnActorUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActorUpdateActionPerformed(evt);
            }
        });

        btnActorAdd.setText("Add");
        btnActorAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActorAddActionPerformed(evt);
            }
        });

        lblErrorActorIcon.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorActorFirstName.setForeground(new java.awt.Color(255, 0, 51));

        jLabel2.setText("Name:");

        lblErrorActorMovies.setForeground(new java.awt.Color(255, 0, 51));

        jLabel4.setText("Movies:");

        jScrollPane3.setViewportView(lsMovieList);

        jScrollPane2.setViewportView(lsAllMoviesList);

        jLabel1.setText("Drag and drop actors:");

        btnClearList.setBackground(new java.awt.Color(255, 153, 153));
        btnClearList.setForeground(new java.awt.Color(0, 51, 51));
        btnClearList.setText("X");
        btnClearList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErrorActorChoose)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfActorPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActorChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnActorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActorUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActorDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErrorActorIcon)
                                .addGap(22, 22, 22)
                                .addComponent(lblNameOfActor, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfActorFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClearList))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblErrorActorMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16))
                                            .addComponent(lblErrorActorFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNameOfActor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorActorIcon))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfActorFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblErrorActorFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblErrorActorMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClearList, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActorUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActorDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActorChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfActorPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorActorChoose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActorAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActorAddActionPerformed
        if (FormUtils.formValid(fields, labels)) {
            try {
                String localPicturePath = uploadPicture();

                Actor actor = new Actor(
                        tfActorFirstName.getText().trim(),
                        localPicturePath,
                        movies
                );
                actorRepository.createOne(actor);
                actorTableModel.setActors(actorRepository.selectList());
                clearForm();

            } catch (Exception ex) {
                Logger.getLogger(ActorEditPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to create actor!");
            }
        } else {
            MessageUtils.showInformationMessage("info", "Please input data");
            clearForm();
        }
    }//GEN-LAST:event_btnActorAddActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void btnActorChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActorChooseActionPerformed
        Optional<File> file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");

        tfActorPicturePath.setText(file.get().getAbsolutePath());
        try {
            setIcon(lblIcon, file);
        } catch (IOException ex) {
            Logger.getLogger(ActorEditPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("No photo", "I am not able to read that photo");
        }
    }//GEN-LAST:event_btnActorChooseActionPerformed

    private void btnActorUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActorUpdateActionPerformed
        if (selectedActor == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please select an actor!");
            return;
        }
        if (FormUtils.formValid(fields, labels)) {

            try {

                if (selectedActor.getPicturePath() == null) {
                    selectedActor.setPicturePath(tfActorPicturePath.getText().trim());
                }
                if (!tfActorPicturePath.getText().trim().equals(selectedActor.getPicturePath())) {
                    Files.deleteIfExists(Paths.get(selectedActor.getPicturePath()));
                }

                selectedActor.setFirstName(tfActorFirstName.getText().trim());
                selectedActor.setMovies(lsMovieList.getSelectedValuesList());

                actorRepository.updateOne(selectedActor.getId(), selectedActor);
                actorTableModel.setActors(actorRepository.selectList());
                MessageUtils.showInformationMessage("YAY", "Actor updated!");
                clearForm();

            } catch (Exception ex) {
                Logger.getLogger(MovieEditPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("ERROR", "Unable to update the actor");
            }
        }

    }//GEN-LAST:event_btnActorUpdateActionPerformed

    private void tbActorTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbActorTableMouseReleased
        showActor();
    }//GEN-LAST:event_tbActorTableMouseReleased

    private void btnActorDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActorDeleteActionPerformed
        if (selectedActor == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose actor to delete");
            return;
        }
        if (MessageUtils.showConfirmDialog(
                "Delete actor",
                "Do you really want to delete actor?") == JOptionPane.YES_OPTION) {
            try {
                if (selectedActor.getPicturePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedActor.getPicturePath()));
                }
                actorRepository.deleteOne(selectedActor.getId());
                actorTableModel.setActors(actorRepository.selectList());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(ActorEditPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete actor!");
            }
        }

    }//GEN-LAST:event_btnActorDeleteActionPerformed

    private void btnClearListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearListActionPerformed
        movieModel.clear();
        lsMovieList.clearSelection();
    }//GEN-LAST:event_btnClearListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActorAdd;
    private javax.swing.JButton btnActorChoose;
    private javax.swing.JButton btnActorDelete;
    private javax.swing.JButton btnActorUpdate;
    private javax.swing.JButton btnClearList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblErrorActorChoose;
    private javax.swing.JLabel lblErrorActorFirstName;
    private javax.swing.JLabel lblErrorActorIcon;
    private javax.swing.JLabel lblErrorActorMovies;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblNameOfActor;
    private javax.swing.JList<Movie> lsAllMoviesList;
    private javax.swing.JList<Movie> lsMovieList;
    private javax.swing.JTable tbActorTable;
    private javax.swing.JTextField tfActorFirstName;
    private javax.swing.JTextField tfActorPicturePath;
    // End of variables declaration//GEN-END:variables

    private String uploadPicture() throws IOException {
        String picturePath = tfActorPicturePath.getText().trim();
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }

  

    private void clearForm() {
        fields.forEach(e -> e.setText(""));
        labels.forEach(e -> e.setText(""));
        //      lblIcon.setIcon(new ImageIcon(getClass().getResource("/assets/no_image.png")));
        movieModel.clear();
        movies.clear();
        selectedActor = null;

        lsMovieList.clearSelection();
    }

    private void init() {
        try {
            initRepo();
            initValidation();
            loadAllMovies();
            initDragNDrop();
            initTable();
        } catch (IOException ex) {
            Logger.getLogger(ActorEditPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecovarable", "Exiting");
            System.exit(1);
        } catch (Exception ex) {
            Logger.getLogger(ActorEditPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setIcon(JLabel label, Optional<File> file) throws IOException {
        label.setIcon(IconUtils.createIcon(file.get().getAbsolutePath(), label.getWidth(), label.getHeight()));
    }

    private void initRepo() throws IOException {
        actorRepository = RepositoryFactory.getActorRepository();
        movieRepository = RepositoryFactory.getMovieRepository();
    }

    private void initValidation() {
        fields = Arrays.asList(tfActorFirstName, tfActorPicturePath);
        labels = Arrays.asList(lblErrorActorFirstName, lblErrorActorChoose, lblErrorActorMovies);

    }

    private void initTable() throws IOException, Exception {
        tbActorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbActorTable.setAutoCreateRowSorter(true);
        tbActorTable.setRowHeight(25);

        actorTableModel = new ActorTableModel(actorRepository.selectList());
        tbActorTable.setModel(actorTableModel);
    }

    private void showActor() {
        int selectedRow = tbActorTable.getSelectedRow();
        int rowIndex = tbActorTable.convertRowIndexToModel(selectedRow);
        int selectedId = (int) tbActorTable.getValueAt(rowIndex, 0);

        try {
            Optional<Actor> opt = actorRepository.selectOne(selectedId);
            if (opt.isPresent()) {
                selectedActor = opt.get();
                fillform(selectedActor);
            }
        } catch (Exception ex) {
            Logger.getLogger(ActorEditPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to fetch actor");
        }
    }

    private void fillform(Actor actor) throws IOException {
        clearForm();
        lblNameOfActor.setText("");
        lblNameOfActor.setText(actor.getFirstName());
        tfActorFirstName.setText(actor.getFirstName());
        if (actor.getPicturePath() != null && Files.exists(Paths.get(actor.getPicturePath()))) {
            tfActorPicturePath.setText(actor.getPicturePath());
            lblIcon.setIcon(IconUtils.createIcon(actor.getPicturePath(), lblIcon.getWidth(), lblIcon.getHeight()));
        }
        movieModel.clear();
        actor.getMovies().forEach((m) -> {
            movies.add(m);
        });
        movies.forEach(movieModel::addElement);
        lsMovieList.setModel(movieModel);

    }

    private void initDragNDrop() {
        lsAllMoviesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsAllMoviesList.setDragEnabled(true);
        lsAllMoviesList.setTransferHandler(new ExportHandler());
        lsMovieList.setDropMode(DropMode.ON);
        lsMovieList.setTransferHandler(new ImportHandler());
    }

    private void loadMovie() {
        movieModel.clear();
        movies.forEach(movieModel::addElement);
        lsMovieList.setModel(movieModel);
    }

    private void loadAllMovies() throws Exception {
        allMoviesModel.clear();
        allMovies = movieRepository.selectList();
        allMovies.forEach(allMoviesModel::addElement);
        lsAllMoviesList.setModel(allMoviesModel);

    }

    private class ImportHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(MovieTransferable.MOVIE_TRANSFERABLE);
        }

        @Override
        public boolean importData(TransferSupport support) {
            try {
                Transferable transferable = support.getTransferable();
                Movie data = (Movie) transferable.getTransferData(MovieTransferable.MOVIE_TRANSFERABLE);
                if (movies.add(data)) {
                    loadMovie();
                    return true;
                }

            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(ActorEditPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

    }

    private class ExportHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new MovieTransferable(lsAllMoviesList.getSelectedValue());
        }

    }
}
