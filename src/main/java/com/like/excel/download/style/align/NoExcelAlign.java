package com.like.excel.download.style.align;

import org.apache.poi.ss.usermodel.CellStyle;

public class NoExcelAlign implements ExcelAlign {

	@Override
	public void apply(CellStyle cellStyle) {
		// Do nothing
	}
}
