package demo;

import bean.tableForTeac;
import dao.teacAndStudDao;

public class teac_crud {

	public static void main(String[] args) {
		teacAndStudDao tasDao = new teacAndStudDao();
		tableForTeac select = tasDao.select(1);
		System.out.println(select.toString());
	}

}
