/*
 * Copyright (C) 2010 Francisco José Morero Peyrona. All Rights Reserved.
 *
 * This file is part of Tapas project: http://code.google.com/p/tapas-tpv/
 *
 * GNU Classpath is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the free
 * Software Foundation; either version 3, or (at your option) any later version.
 *
 * Tapas is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Tapas; see the file COPYING.  If not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.peyrona.tapas.office;

import com.peyrona.tapas.Utils;
import com.peyrona.tapas.persistence.Product;
import com.peyrona.tapas.persistence.DataProvider;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Esta clase se encarga de gestionar las categorías de productos (AKA familias)
 * en la pestaña "Carta" de la ventana de la configuración (véase la clase OfficePanel).
 *
 * @author Francisco Morero Peyrona
 */
final class Menu extends JPanel implements ActionListener
{
    private static final String sACT_ADD_LINE  = "add_line";
    private static final String sACT_DEL_LINE  = "del_line";
    private static final String sACT_UP_LINE   = "shift_up_line";
    private static final String sACT_DOWN_LINE = "shift_down_line";

    private enum Owner { Categories, Products };

    private JTables4Menu.TableCategories tblCategories;
    private JTables4Menu.TableProducts   tblProducts;

    //------------------------------------------------------------------------//

    Menu()
    {
        tblCategories = new JTables4Menu.TableCategories();
        tblProducts   = new JTables4Menu.TableProducts();

        setLayout( new BorderLayout() );
        initComponents();
    }

    /**
     * Invocado desde OfficeDialog antes de que la dialog se cierre.
     *
     * @param ae
     */
    @Override
    public void actionPerformed( ActionEvent ae )
    {
        if( tblCategories.isDataChanged() || tblProducts.isDataChanged() )
        {
            DataProvider.getInstance().setCategoriesAndProducts( tblCategories.getData() );
        }
    }

    //------------------------------------------------------------------------//

    /**
     * Método invocado cuando se activa algún botón de la button bar del panel
     *
     * @param ae El ActionEvent que evían los JButton
     */
    private void onButtonClicked( ActionEvent ae )
    {
        Button button  = (Button) ae.getSource();
        Owner  owner   = button.getOwner();
        String sAction = button.getActionCommand();

        if( owner == Owner.Categories )
        {
                 if( sACT_ADD_LINE.equals(  sAction ) )  tblCategories.addRow( new Product() );
            else if( sACT_DEL_LINE.equals(  sAction ) )  tblCategories.deleteHighlightedRow();
            else if( sACT_UP_LINE.equals(   sAction ) )  tblCategories.shiftUpHighlightedRow();
            else if( sACT_DOWN_LINE.equals( sAction ) )  tblCategories.shiftDownHighlightedRow();
        }
        else
        {
                 if( sACT_ADD_LINE.equals(  sAction ) )  tblProducts.addRow( new Product() );
            else if( sACT_DEL_LINE.equals(  sAction ) )  tblProducts.deleteHighlightedRow();
            else if( sACT_UP_LINE.equals(   sAction ) )  tblProducts.shiftUpHighlightedRow();
            else if( sACT_DOWN_LINE.equals( sAction ) )  tblProducts.shiftDownHighlightedRow();
        }
    }

    private void initComponents()
    {
        JPanel pnlToolBar4Cate = new JPanel( new FlowLayout( FlowLayout.LEADING ) );
               pnlToolBar4Cate.add( new Button( new ImageIcon( getClass().getResource( "images/add.png" ) ),
                                                "Añade una nueva categoría", Owner.Categories, sACT_ADD_LINE ) );
               pnlToolBar4Cate.add( new Button( new ImageIcon( getClass().getResource( "images/del.png" ) ),
                                                "Elimina la categoría resaltada", Owner.Categories, sACT_DEL_LINE ) );
               pnlToolBar4Cate.add( new Button( new ImageIcon( getClass().getResource( "images/up.png" ) ),
                                                "Desplaza la categoría resaltada hacia arriba", Owner.Categories, sACT_UP_LINE ) );
               pnlToolBar4Cate.add( new Button( new ImageIcon( getClass().getResource( "images/down.png" ) ),
                                                "Desplaza la categoría resaltada hacia abajo", Owner.Categories, sACT_DOWN_LINE ) );

        JPanel pnlToolBar4Prod = new JPanel( new FlowLayout( FlowLayout.TRAILING ) );
               pnlToolBar4Prod.add( new Button( new ImageIcon( getClass().getResource( "images/add.png" ) ),
                                                "Añade un nuevo producto", Owner.Products, sACT_ADD_LINE ) );
               pnlToolBar4Prod.add( new Button( new ImageIcon( getClass().getResource( "images/del.png" ) ),
                                                "Elimina el producto resaltado",Owner.Products, sACT_DEL_LINE ) );
               pnlToolBar4Prod.add( new Button( new ImageIcon( getClass().getResource( "images/up.png" ) ),
                                                "Desplaza el producto resaltado hacia arriba", Owner.Products, sACT_UP_LINE ) );
               pnlToolBar4Prod.add( new Button( new ImageIcon( getClass().getResource( "images/down.png" ) ),
                                                "Desplaza el producto resaltado hacia abajo", Owner.Products, sACT_DOWN_LINE ) );

        JPanel pnlCategories = new JPanel( new BorderLayout() );
               pnlCategories.add( new JLabel( "Categorías" )      , BorderLayout.NORTH  );
               pnlCategories.add( new JScrollPane( tblCategories ), BorderLayout.CENTER );
               pnlCategories.add( pnlToolBar4Cate                 , BorderLayout.SOUTH  );

        JPanel pnlProducts = new JPanel( new BorderLayout() );
               pnlProducts.add( new JLabel( "Productos" )     , BorderLayout.NORTH  );
               pnlProducts.add( new JScrollPane( tblProducts ), BorderLayout.CENTER );
               pnlProducts.add( pnlToolBar4Prod               , BorderLayout.SOUTH  );

        final JSplitPane spBoth = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT,
                                                  (Utils.getCores() > 1),
                                                  pnlCategories, pnlProducts );
                         spBoth.setOneTouchExpandable( true );

        EventQueue.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                spBoth.setDividerLocation( .40d );
            }
        } );

        add( spBoth, BorderLayout.CENTER );

        // Añade todas las categorías existentes (los productos se refrescan
        // automáticamente mediante un selection listener)
        List<Product> all = DataProvider.getInstance().getCategoriesAndProducts();

        if( all.isEmpty() )
        {
            all.add( new Product() );
        }

        // Al utilizar "all" directamente, los cambios se realizan tanto en "vLines" como en "all"
        tblCategories.setData( all );
        tblProducts.setData( all.get( 0 ).getSubMenu() );

        // Lo elegante sería crear un nuevo tipo de evento y poner a Products como escuchante
        // de Categories, pasando los datos, pero eso es mucho trabajo para tan poca cosa.
        tblCategories.getSelectionModel().addListSelectionListener( new ListSelectionListener()
        {
            @Override
            public void valueChanged( ListSelectionEvent lse )
            {
                if( ! lse.getValueIsAdjusting() )
                {
                    int nSelectedRowInCategories = Menu.this.tblCategories.getSelectedRow();

                    if( nSelectedRowInCategories > -1 )
                    {
                        Product category = Menu.this.tblCategories.getData().get( nSelectedRowInCategories );
                        Menu.this.tblProducts.setData( category.getSubMenu() );
                    }
                }
            }
        } );
    }

    //------------------------------------------------------------------------//
    // Inner Class
    //------------------------------------------------------------------------//
    private final class Button extends JButton implements ActionListener
    {
        private Owner owner;

        private Button( ImageIcon icon, String sToolTip, Owner owner, String sAction )
        {
            this.owner = owner;

            setIcon( icon );
            setToolTipText( sToolTip );
            setActionCommand( sAction );
            setFocusPainted( false );
            setMargin( new Insets( 4,4,4,4 ) );
            addActionListener( Button.this );
        }

        private Owner getOwner()
        {
            return owner;
        }

        @Override
        public void actionPerformed( ActionEvent ae )
        {
            Menu.this.onButtonClicked( ae );
        }
    }
}