/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model;

import com.microsoft.sqlserver.jdbc.StringUtils;
import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Movie;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.FormUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import hr.algebra.view.model.table.MovieTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Jo
 */
public class MovieEditPanel extends javax.swing.JPanel {

    private List<JTextComponent> fields;
    private List<JLabel> labels;
    private static final String DIR = "assets";
    private Repository repository;
    private MovieTableModel movieTableModel;
    private Movie selectedMovie;

    /**
     * Creates new form MovieEditView
     */
    public MovieEditPanel() {
        initComponents();
    }

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
        tbMovieTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfMovieTitle = new javax.swing.JTextField();
        tfMoviePubDate = new javax.swing.JTextField();
        tfMovieOrigTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfMovieActors = new javax.swing.JTextField();
        tfMovieDirector = new javax.swing.JTextField();
        tfMovieDuration = new javax.swing.JTextField();
        tfMovieGenre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMovieDescription = new javax.swing.JTextArea();
        btnMovieChoose = new javax.swing.JButton();
        tfMoviePicturePath = new javax.swing.JTextField();
        btnMovieUpdate = new javax.swing.JButton();
        btnMovieAdd = new javax.swing.JButton();
        btnMovieDelete = new javax.swing.JButton();
        lblErrorMovieDesc = new javax.swing.JLabel();
        lblErrorPubDate = new javax.swing.JLabel();
        lblErrorMovieTitle = new javax.swing.JLabel();
        lblErrorMovieOrigTitle = new javax.swing.JLabel();
        lblErrorMovieActors = new javax.swing.JLabel();
        lblErrorMovieDirector = new javax.swing.JLabel();
        lblErrorMovieDuration = new javax.swing.JLabel();
        lblErrorMovieGenre = new javax.swing.JLabel();
        lblErrorMovieIcon = new javax.swing.JLabel();
        lblErrorMoviePicturePath = new javax.swing.JLabel();

        setBackground(new java.awt.Color(230, 230, 249));
        setPreferredSize(new java.awt.Dimension(1192, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/assets/no_image.png"))); // NOI18N
        lblIcon.setRequestFocusEnabled(false);

        tbMovieTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMovieTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMovieTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbMovieTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbMovieTable);

        jLabel1.setLabelFor(tfMovieTitle);
        jLabel1.setText("Title:");

        jLabel2.setText("Published date:");

        tfMoviePubDate.setText("1234-12-12");

        jLabel3.setText("Description:");

        jLabel4.setText("Original title:");

        jLabel5.setText("Duration:");

        jLabel6.setText("Genre:");

        jLabel7.setText("Actors:");

        jLabel8.setText("Director:");

        taMovieDescription.setColumns(20);
        taMovieDescription.setRows(5);
        jScrollPane2.setViewportView(taMovieDescription);

        btnMovieChoose.setText("Choose");
        btnMovieChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieChooseActionPerformed(evt);
            }
        });

        btnMovieUpdate.setText("Update");
        btnMovieUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieUpdateActionPerformed(evt);
            }
        });

        btnMovieAdd.setText("Add");
        btnMovieAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieAddActionPerformed(evt);
            }
        });

        btnMovieDelete.setBackground(new java.awt.Color(255, 153, 153));
        btnMovieDelete.setText("Delete");
        btnMovieDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovieDeleteActionPerformed(evt);
            }
        });

        lblErrorMovieDesc.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorPubDate.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorMovieTitle.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorMovieOrigTitle.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorMovieActors.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorMovieDirector.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorMovieDuration.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorMovieGenre.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorMovieIcon.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorMoviePicturePath.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErrorMoviePicturePath)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMoviePicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMovieChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblErrorMovieIcon)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfMovieActors)
                                        .addComponent(tfMovieDirector)
                                        .addComponent(tfMovieDuration)
                                        .addComponent(tfMovieGenre)
                                        .addComponent(tfMovieOrigTitle)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfMovieTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMoviePubDate, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblErrorMovieTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblErrorMovieDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblErrorMovieOrigTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblErrorMovieActors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblErrorMovieDirector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblErrorMovieGenre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblErrorMovieDuration))
                                    .addComponent(lblErrorPubDate)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMovieAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMovieUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMovieDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorMovieIcon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfMovieTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfMoviePubDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblErrorMovieTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(lblErrorPubDate)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfMovieOrigTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorMovieOrigTitle)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfMovieActors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorMovieActors)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfMovieDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorMovieDirector)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfMovieDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorMovieDuration)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfMovieGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorMovieGenre)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErrorMovieDesc)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMovieUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMovieAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMovieDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMovieChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMoviePicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorMoviePicturePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMovieAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieAddActionPerformed
        if (FormUtils.formValid(fields, labels)) {
           if (StringUtils.isNumeric(tfMovieDuration.getText().trim())) {

            try {
                Director director = handleDirector(tfMovieDirector.getText().trim());
                String localPicturePath = uploadPicture();
                List<Actor> actors = handleActor(tfMovieActors.getText().trim());
                    
                
                Movie movie = new Movie(
                        tfMovieTitle.getText().trim(),
                        LocalDate.parse(tfMoviePubDate.getText().trim(), Movie.DATE_FORMATTER),
                        taMovieDescription.getText().trim(),
                        tfMovieOrigTitle.getText().trim(),
                        director,
                        actors,
                        Integer.valueOf(tfMovieDuration.getText().trim()),
                        tfMovieGenre.getText().trim(),
                        localPicturePath
                );
                
                repository.createOne(movie);
                movieTableModel.setMovies(repository.selectList());
                MessageUtils.showInformationMessage("Success!!", "Movie added!");
                
                clearForm();
                
               }
             catch (Exception ex) {
                Logger.getLogger(MovieEditPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to create movie!");
            }
        }
           else{
            MessageUtils.showInformationMessage("info", "Please input duration as a number.");
            tfMovieDuration.setText("");
           }
        } else {
            MessageUtils.showInformationMessage("info", "Please input data");
            clearForm();
        }

    }//GEN-LAST:event_btnMovieAddActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void btnMovieChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieChooseActionPerformed
        Optional<File> file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");

        tfMoviePicturePath.setText(file.get().getAbsolutePath());
        try {
            setIcon(lblIcon, file);
        } catch (IOException ex) {
            Logger.getLogger(MovieEditPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("No photo", "I am not able to read that photo");
        }
    }//GEN-LAST:event_btnMovieChooseActionPerformed

    private void btnMovieUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieUpdateActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please select a movie");
            return;
        }
        if (FormUtils.formValid(fields, labels)) {
            try {
                Director director = handleDirector(tfMovieDirector.getText().trim());

                //             if (!tfMoviePicturePath.getText().trim().equals(selectedMovie.getPicturePath())) {
                //                 Files.deleteIfExists(Paths.get(selectedMovie.getPicturePath()));
                //             
                selectedMovie.setTitle(tfMovieTitle.getText().trim());
                selectedMovie.setPubDate(LocalDate.parse(tfMoviePubDate.getText().trim(), Movie.DATE_FORMATTER));
                selectedMovie.setDescription(taMovieDescription.getText().trim());
                selectedMovie.setOrigiTitle(tfMovieOrigTitle.getText().trim());
                selectedMovie.setActors(handleActor(tfMovieActors.getText().trim()));
                selectedMovie.setDirector(director);
                selectedMovie.setDuration(Integer.valueOf(tfMovieDuration.getText().trim()));
                selectedMovie.setGenre(tfMovieGenre.getText().trim());

                repository.updateOne(selectedMovie.getId(), selectedMovie);
                movieTableModel.setMovies(repository.selectList());
                MessageUtils.showInformationMessage(" operation", "You updated!");

                                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(MovieEditPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("ERROR", "Unable to update the movie");
            }
        }

    }//GEN-LAST:event_btnMovieUpdateActionPerformed

    private void btnMovieDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovieDeleteActionPerformed

        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose movie to delete");
            return;
        }
        if (MessageUtils.showConfirmDialog(
                "Delete movie",
                "Do you really want to delete movie?") == JOptionPane.YES_OPTION) {
            try {
                if (selectedMovie.getPicturePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedMovie.getPicturePath()));
                }
                repository.deleteOne(selectedMovie.getId());
                movieTableModel.setMovies(repository.selectList());

                 clearForm();
            } catch (Exception ex) {
                Logger.getLogger(MovieEditPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete movie!");
            }
        }


    }//GEN-LAST:event_btnMovieDeleteActionPerformed

    private void tbMovieTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMovieTableMouseReleased
        showMovie();
    }//GEN-LAST:event_tbMovieTableMouseReleased

    private void tbMovieTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMovieTableMouseClicked
  showMovie();    }//GEN-LAST:event_tbMovieTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMovieAdd;
    private javax.swing.JButton btnMovieChoose;
    private javax.swing.JButton btnMovieDelete;
    private javax.swing.JButton btnMovieUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErrorMovieActors;
    private javax.swing.JLabel lblErrorMovieDesc;
    private javax.swing.JLabel lblErrorMovieDirector;
    private javax.swing.JLabel lblErrorMovieDuration;
    private javax.swing.JLabel lblErrorMovieGenre;
    private javax.swing.JLabel lblErrorMovieIcon;
    private javax.swing.JLabel lblErrorMovieOrigTitle;
    private javax.swing.JLabel lblErrorMoviePicturePath;
    private javax.swing.JLabel lblErrorMovieTitle;
    private javax.swing.JLabel lblErrorPubDate;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JTextArea taMovieDescription;
    private javax.swing.JTable tbMovieTable;
    private javax.swing.JTextField tfMovieActors;
    private javax.swing.JTextField tfMovieDirector;
    private javax.swing.JTextField tfMovieDuration;
    private javax.swing.JTextField tfMovieGenre;
    private javax.swing.JTextField tfMovieOrigTitle;
    private javax.swing.JTextField tfMoviePicturePath;
    private javax.swing.JTextField tfMoviePubDate;
    private javax.swing.JTextField tfMovieTitle;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initValidation();
            initRepository();
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(MovieEditPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecovarable", "Exiting");
            System.exit(1);
        }
    }

    private void initValidation() {
        fields = Arrays.asList(tfMovieTitle, tfMoviePubDate, taMovieDescription, tfMovieOrigTitle, tfMovieActors, tfMovieDirector, tfMovieDuration, tfMovieGenre, tfMoviePicturePath);
        labels = Arrays.asList(lblErrorMovieTitle, lblErrorPubDate, lblErrorMovieDesc, lblErrorMovieOrigTitle, lblErrorMovieActors, lblErrorMovieDirector, lblErrorMovieDuration, lblErrorMovieGenre, lblErrorMoviePicturePath);

    }

    private void setIcon(JLabel label, Optional<File> file) throws IOException {
        label.setIcon(IconUtils.createIcon(file.get().getAbsolutePath(), label.getWidth(), label.getHeight()));
    }

    private List<Actor> handleActor(String data) {
        List<Actor> actors = new ArrayList<>();

        String[] resoults = data.split(",");
        for (String res : resoults) {
            actors.add(new Actor(
                    res
            ));
        }
        return actors;
    }

    private String uploadPicture() throws IOException {
        String picturePath = tfMoviePicturePath.getText().trim();
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;

    }

    private void clearForm() {
        fields.forEach(e -> e.setText(""));
        labels.forEach(e -> e.setText(""));
   //     lblIcon.setIcon(new ImageIcon(getClass().getResource("assets")));

        selectedMovie = null;
    }

    private void initTable() throws IOException, Exception {
        tbMovieTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovieTable.setAutoCreateRowSorter(true);

        tbMovieTable.setRowHeight(25);

        movieTableModel = new MovieTableModel(repository.selectList());
        tbMovieTable.setModel(movieTableModel);
    }

    private void initRepository() throws IOException {
        repository = RepositoryFactory.getMovieRepository();
    }

    private void showMovie() {
        clearForm();
        int selectedRow = tbMovieTable.getSelectedRow();
        int rowIndex = tbMovieTable.convertRowIndexToModel(selectedRow);
        int selectedId = (int) movieTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Movie> opt = repository.selectOne(selectedId);
            if (opt.isPresent()) {
                selectedMovie = opt.get();
                fillform(selectedMovie);
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieEditPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to fetch movie");
        }
    }

    private void fillform(Movie movie) throws IOException {
        tfMovieTitle.setText(movie.getTitle());
        tfMoviePubDate.setText(movie.getPubDate().format(Movie.DATE_FORMATTER));
        taMovieDescription.setText(movie.getDescription());
        tfMovieOrigTitle.setText(movie.getOrigiTitle());
        tfMovieActors.setText(handleObjToString(movie.getActors()));
        tfMovieDirector.setText(movie.getDirector().toString());
        tfMovieDuration.setText(String.valueOf(movie.getDuration()));
        tfMovieGenre.setText(movie.getGenre());
        if (movie.getPicturePath() != null && Files.exists(Paths.get(movie.getPicturePath()))) {
            tfMoviePicturePath.setText(movie.getPicturePath());
            lblIcon.setIcon(IconUtils.createIcon(movie.getPicturePath(), lblIcon.getWidth(), lblIcon.getHeight()));
        }
        tfMoviePicturePath.setText(movie.getPicturePath());

    }

    private String handleObjToString(List<Actor> actors) {
        StringBuilder sb = new StringBuilder();
        actors.forEach((actor) -> {
            sb.append(actor.getFirstName());
            sb.append(", ");
        });

        return sb.toString();
    }

    private Director handleDirector(String name) throws Exception {

        return new Director(name);
    }
}