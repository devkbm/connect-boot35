package com.like.excel.download.style.color;

import org.apache.poi.ss.usermodel.CellStyle;

public class NoExcelColor implements ExcelColor {

	@Override
	public void applyForeground(CellStyle cellStyle) {
		// Do nothing
	}

}
