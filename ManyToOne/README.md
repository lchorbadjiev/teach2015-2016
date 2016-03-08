#Задача: контейнер поддържащ релация many-to-one

Настоящото упражнение се базирано върху задачата many-to-one на Кирил Митов [http://lubo.elsys-bg.org/wp-content/uploads/2009/02/manytoone.pdf](http://lubo.elsys-bg.org/wp-content/uploads/2009/02/manytoone.pdf)


## Имплементация на `ManyToOneRelation` 

Да се имплементира контейнерен клас `ManyToOneRelation` съгласно следната [спецификация](https://github.com/lchorbadjiev/teach2015-2016/blob/master/ManyToOne/src/org/elsys/manytoone/ManyToOneRelation.java):

```java
package org.elsys.manytoone;

import java.util.Collection;

/**
 * Introduces the notation of many-to-one relation. This is where the M and O of
 * the type signature comes from.
 *
 * Many unique "source" objects refer to one and only "target" object.
 *
 * The class maintains a connection between the target and all the sources that
 * are referring to it.
 *
 * @author Kiril Mitov k.mitov@sap.com
 *
 * @param <M>
 *            the type of the "source" objects.
 * @param <O>
 *            the type of the "target" objects.
 */
public class ManyToOneRelation<M, O> {
	/**
	 * Connects the given source with the given target. If this source was
	 * previously connected with another target the old connection is lost.
	 *
	 * @param source
	 * @param target
	 * @return
	 */
	public boolean connect(M source, O target) {
		return false;
	}

	/**
	 * @param source
	 * @return <code>true</code> if the relation contains the given source
	 */
	public boolean containsSource(M source) {
		return false;
	}

	/**
	 * @param target
	 * @return <code>true</code> if the relation contains the given target
	 */
	public boolean containsTarget(O target) {
		return false;
	}

	/**
	 * @param source
	 * @return the target with which this source is connected
	 */
	public O getTarget(M source) {
		return null;
	}

	/**
	 * @param target
	 * @return all the targets that are connected with this source or empty
	 *         collection if there are no sources connected with this target.
	 */
	public Collection<M> getSources(O target) {
		return null;
	}

	/**
	 * Removes the connection between this source and the corresponding target.
	 * Other sources will still point to the same target.
	 *
	 * The target is removed if this was the only source pointing to it and
	 * {@link #containsTarget(Object)} will return false.
	 *
	 * @param source
	 */
	public void disconnectSource(M source) {
	}

	/**
	 * Removes the given target from the relation. All the sources that are
	 * pointing to this target are also removed.
	 *
	 * If you take the "result" of {@link #getSources(target)} and after that
	 * call this method then {@link #containsSource(Object)} will return
	 * <code>false</code> for every object in "result".
	 *
	 * @param target
	 */
	public void disconnect(O target) {
	}

	/**
	 * @return a collection of the targets.
	 */
	public Collection<O> getTargets() {
		return null;
	}
}

```


## Тестване на методите на `ManyToOneRelation`

При разработването на `ManyToOneRelation` да се добавят JUnit тестове за всеки от методите в класа [`ManyToOneRelationTestCase`](https://github.com/lchorbadjiev/teach2015-2016/blob/master/ManyToOne/src/org/elsys/manytoone/ManyToOneRelationTestCase.java).


## Имплементиране на методите `equals` и `hashCode`

В класа `ManyToOneRelation` да се добави имплементация на методите `equals` и `hashCode` така, че тестовете в класа [`ManyToOneRelationRequiredTestCase`](https://github.com/lchorbadjiev/teach2015-2016/blob/master/ManyToOne/src/org/elsys/manytoone/ManyToOneRelationTestCase.java)

```java
package org.elsys.manytoone;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManyToOneRelationRequiredTestCase {

	@Test
	public void testEqualsTrue() throws Exception {
		ManyToOneRelation<String, Integer> relation1 = new ManyToOneRelation<String, Integer>();
		ManyToOneRelation<String, Integer> relation2 = new ManyToOneRelation<String, Integer>();
		relation1.connect("Integer1", new Integer(1));
		relation1.connect("Integer2", new Integer(2));
		relation2.connect("Integer1", new Integer(1));
		relation2.connect("Integer2", new Integer(2));
		assertTrue(relation1.equals(relation2));
	}

	@Test
	public void testEqualsFalse() throws Exception {
		ManyToOneRelation<String, Integer> relation1 = new ManyToOneRelation<String, Integer>();
		ManyToOneRelation<String, Integer> relation2 = new ManyToOneRelation<String, Integer>();
		relation1.connect("Integer1", new Integer(1));
		relation2.connect("Integer1", new Integer(1));
		relation2.connect("Integer2", new Integer(2));
		assertFalse(relation1.equals(relation2));
	}
}

```


