package com.like.excel.download;

import com.like.excel.download.style.ExcelCellStyle;

public @interface ExcelColumnStyle {

	/**
	 * Enum implements {@link com.like.excel.download.style.lannstark.style.ExcelCellStyle}
	 * Also, can use just class.
	 * If not use Enum, enumName will be ignored
	 * @see com.like.excel.download.style.lannstark.style.DefaultExcelCellStyle
	 * @see com.like.excel.download.style.lannstark.style.CustomExcelCellStyle
	 */
	Class<? extends ExcelCellStyle> excelCellStyleClass();

	/**
	 * name of Enum implements {@link com.like.excel.download.style.lannstark.style.ExcelCellStyle}
	 * if not use Enum, enumName will be ignored
	 */
	String enumName() default "";

}