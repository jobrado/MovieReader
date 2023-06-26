/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author Jo
 */
public class MovieTransferable implements Transferable {

    public static final DataFlavor MOVIE_TRANSFERABLE = new DataFlavor(Movie.class, "Movie");
    private static final DataFlavor[] SUPPORTED_TRANSFERABLE = {MOVIE_TRANSFERABLE};

    private final Movie movie;

    public MovieTransferable(Movie movie) {
        this.movie = movie;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return SUPPORTED_TRANSFERABLE;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return MOVIE_TRANSFERABLE.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return movie;
        }
        throw new UnsupportedFlavorException(flavor);
    }

}
