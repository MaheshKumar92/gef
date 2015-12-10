/*******************************************************************************
 * Copyright (c) 2014, 2015 itemis AG and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Alexander Nyßen (itemis AG) - initial API and implementation
 *    
 *******************************************************************************/
package org.eclipse.gef4.geometry.convert.fx;

import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.transform.Transform;

import org.eclipse.gef4.geometry.planar.AffineTransform;
import org.eclipse.gef4.geometry.planar.Point;
import org.eclipse.gef4.geometry.planar.Rectangle;
import org.eclipse.gef4.geometry.planar.Path.Segment;

/**
 * Utility class to support the conversion between JavaFX objects and
 * corresponding classes of the GEF4 geometry API.
 * 
 * @author anyssen
 *
 */
public class JavaFX2Geometry {

	private JavaFX2Geometry() {
		// this class should not be instantiated by clients
	}

	/**
	 * Converts the given JavaFX {@link Transform} to an {@link AffineTransform}
	 * .
	 * 
	 * @param t
	 *            The JavaFX {@link Transform} to convert.
	 * @return The new {@link AffineTransform}.
	 */
	public static final AffineTransform toAffineTransform(Transform t) {
		return new AffineTransform(t.getMxx(), t.getMyx(), t.getMxy(), t.getMyy(), t.getTx(), t.getTy());
	}

	/**
	 * Converts the given JavaFX {@link Bounds} to a {@link Rectangle}.
	 * 
	 * @param b
	 *            The JavaFX {@link Bounds} to convert.
	 * @return The new {@link Rectangle}.
	 */
	public static final Rectangle toRectangle(Bounds b) {
		return new Rectangle(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());
	}

	/**
	 * Converts the given JavaFX {@link Point2D} to a {@link Point}.
	 * 
	 * @param point
	 *            The {@link Point2D} to convert.
	 * @return The new {@link Point}.
	 */
	public static final Point toPoint(Point2D point) {
		return new Point(point.getX(), point.getY());
	}

}
