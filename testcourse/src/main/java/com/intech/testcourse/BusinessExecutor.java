package com.intech.testcourse;

public class BusinessExecutor {
	
	private BusinessHelper businessHelper;
	
	private FileService fileService;
	
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	
	public BusinessExecutor(BusinessHelper h) {
		this.businessHelper = h;
		this.fileService = new FileService();
	}
	
	public int execute(int rank) {
		int res = businessHelper.treatment();
		return rank*res;		
	}
	
	public String toUpperText() {
		String info = fileService.getInfo();
		info = info.toUpperCase(); // Met en majuscule le texte.
		return info;
	}
	
}