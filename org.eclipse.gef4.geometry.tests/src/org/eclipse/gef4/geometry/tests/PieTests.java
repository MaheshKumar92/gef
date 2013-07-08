/*******************************************************************************
 * Copyright (c) 2013 itemis AG and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Matthias Wienand (itemis AG) - initial API and implementation
 * 
 *******************************************************************************/
package org.eclipse.gef4.geometry.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.gef4.geometry.euclidean.Angle;
import org.eclipse.gef4.geometry.planar.BezierCurve;
import org.eclipse.gef4.geometry.planar.CurvedPolygon;
import org.eclipse.gef4.geometry.planar.Pie;
import org.junit.Test;

public class PieTests {

	@Test
	public void test_getOutlineSegments() {
		Pie pie = new Pie(0, 0, 100, 100, Angle.fromDeg(90), Angle.fromDeg(270));
		BezierCurve[] outlineSegments = pie.getOutlineSegments();
		CurvedPolygon bakery = new CurvedPolygon(outlineSegments);
		assertTrue("the curved polygon must contain the pie",
				bakery.contains(pie));
	}

}
