package com.tirthal.learning.mapping.association.one2many;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tirthal.learning.util.HibernateUtil;

/**
 * Demo application to show one-to-many association.
 * 
 * Run this program and check "O2M_BILL" and "O2M_BILLLINEITEM" table in database.
 * 
 * @author tirthalp
 * 
 */
public class TestOneToManyDemo {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(TestOneToManyDemo.class);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		logger.debug("*********************************************");
		try {

			Bill bill = new Bill("B#001");
			Collection<BillLineItem> l1 = new ArrayList<BillLineItem>();
			l1.add(new BillLineItem("Blue Pen", 2.50, bill));
			l1.add(new BillLineItem("Red Pen", 2.75, bill));
			l1.add(new BillLineItem("Book", 12.50, bill));
			l1.add(new BillLineItem("Bag", 150, bill));
			bill.setLineItems(l1);

			session.save(bill);

			tx.commit();

			logger.debug("Bill and Bill line item data is saved successfully.");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		// Reading bill having billRefNo = "B#001"
		session = HibernateUtil.getSessionFactory().openSession();
		Bill b = (Bill) session.createCriteria(Bill.class).add(Restrictions.eq("billRefNo", "B#001")).uniqueResult();
		logger.debug("Bill = ID:" + b.getId() + ", Ref No:" + b.getBillRefNo() + ", Line items:" + b.getLineItems());
		session.close();

		logger.debug("*********************************************");
		HibernateUtil.shutdown();
	}

}
