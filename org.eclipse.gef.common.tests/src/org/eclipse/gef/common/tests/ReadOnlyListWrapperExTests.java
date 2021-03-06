/*******************************************************************************
 * Copyright (c) 2017 itemis AG and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthias Wienand (itemis AG) - initial API & implementation
 *
 *******************************************************************************/
package org.eclipse.gef.common.tests;

import java.util.Collections;

import org.eclipse.gef.common.beans.property.ReadOnlyListWrapperEx;
import org.eclipse.gef.common.tests.ObservableListTests.ListChangeExpector;
import org.junit.Test;

import javafx.beans.property.ReadOnlyListProperty;
import javafx.collections.FXCollections;

public class ReadOnlyListWrapperExTests {

	@Test
	public void readOnlyWrapperChangeNotifications() {
		ReadOnlyListWrapperEx<Integer> listWrapper = new ReadOnlyListWrapperEx<>(
				FXCollections.observableArrayList());
		ReadOnlyListProperty<Integer> roProperty = listWrapper
				.getReadOnlyProperty();
		ListChangeExpector<Integer> listChangeListener = new ListChangeExpector<>(
				roProperty);
		roProperty.addListener(listChangeListener);
		listChangeListener.addAtomicExpectation();
		listChangeListener.addElementaryExpectation(null,
				Collections.singletonList(1), null, 0, 1);
		roProperty.add(1);
		listChangeListener.check();
	}
}
