/*******************************************************************************
 * Copyright (c) 2011 itemis AG and others.
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.gef4.geometry.euclidean.Angle;
import org.eclipse.gef4.geometry.planar.Point;
import org.eclipse.gef4.geometry.utils.PrecisionUtils;
import org.junit.Test;

public class AngleTests {

	private static final double PRECISION_FRACTION = TestUtils
			.getPrecisionFraction();

	private static final double UNRECOGNIZABLE_FRACTION = PRECISION_FRACTION
			- PRECISION_FRACTION / 10;

	@Test
	public void test_constructors() {
		Angle alpha = Angle.fromDeg(180);
		assertTrue(alpha.equals(new Angle(Math.PI)));
		assertTrue(alpha.equals(Angle.fromDeg(180)));
		assertTrue(alpha.equals(Angle.fromRad(Math.PI)));
		assertTrue(new Angle().equals(Angle.fromRad(0)));
	}

	@Test
	public void test_copy() {
		Angle alpha = Angle.fromRad(0.234);
		assertTrue(alpha.equals(alpha.getCopy()));
		assertTrue(alpha.equals(alpha.clone()));
		assertTrue(alpha.getCopy().equals(alpha.clone()));
	}

	@Test
	public void test_deg() {
		Angle alpha = Angle.fromDeg(180);
		Angle beta = new Angle(Math.PI);

		assertTrue(PrecisionUtils.equal(180, alpha.deg()));
		assertTrue(PrecisionUtils.equal(180, beta.deg()));

		for (double rad = 0; rad <= 2 * Math.PI; rad += 0.1) {
			assertTrue(Angle.fromDeg(Angle.fromRad(rad).deg()).equals(
					Angle.fromRad(rad)));
		}
	}

	@Test
	public void test_equals() {
		Angle alpha = new Angle(Math.PI);
		Angle beta = new Angle(Math.PI);
		Angle gamma = new Angle(0);
		Angle delta = new Angle(2 * Math.PI);

		assertTrue(alpha.equals(alpha));
		assertTrue(alpha.equals(beta));
		assertFalse(alpha.equals(gamma));
		assertFalse(alpha.equals(delta));
		assertTrue(gamma.equals(delta));
		assertTrue(delta.equals(gamma));
		assertFalse(alpha.equals(null));
		assertFalse(alpha.equals(new Point()));

		alpha = new Angle(UNRECOGNIZABLE_FRACTION / 2);
		beta = new Angle(2 * Math.PI - UNRECOGNIZABLE_FRACTION / 2);
		assertTrue(alpha.equals(beta));
		assertTrue(beta.equals(alpha));

	}

	@Test
	public void test_getAdded() {
		Angle alpha = Angle.fromDeg(180);
		Angle beta = new Angle(Math.PI);

		assertTrue(alpha.getAdded(beta).equals(beta.getAdded(alpha)));
	}

	@Test
	public void test_getMultiplied() {
		Angle alpha = Angle.fromDeg(180);

		assertTrue(alpha.getMultiplied(2).equals(Angle.fromDeg(360)));
	}

	@Test
	public void test_norm() {
		Angle alpha = Angle.fromDeg(361);
		Angle beta = Angle.fromDeg(1);

		assertTrue(alpha.equals(beta));
		assertTrue(PrecisionUtils.equal(alpha.deg(), beta.deg()));
		assertTrue(PrecisionUtils.equal(alpha.rad(), beta.rad()));
	}

	@Test
	public void test_opposite() {
		Angle alpha = Angle.fromDeg(180);

		assertTrue(alpha.equals(alpha.getOppositeFull()));
		assertTrue(alpha.getOppositeSemi().equals(Angle.fromRad(0)));
	}

	@Test
	public void test_set() {
		Angle alpha = Angle.fromDeg(0);

		alpha.setDeg(90);
		assertTrue(PrecisionUtils.equal(alpha.deg(), 90));
		alpha.setDeg(450);
		assertTrue(PrecisionUtils.equal(alpha.deg(), 90));
		alpha.setRad(Math.PI);
		assertTrue(PrecisionUtils.equal(alpha.rad(), Math.PI));
		alpha.setRad(3 * Math.PI);
		assertTrue(PrecisionUtils.equal(alpha.rad(), Math.PI));
	}

	@Test
	public void test_toString() {
		Angle alpha = Angle.fromDeg(0);
		assertEquals("Angle(0.0rad (0.0deg))", alpha.toString());
	}

}
