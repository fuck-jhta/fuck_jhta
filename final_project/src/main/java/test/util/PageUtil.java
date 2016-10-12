package test.util;

public class PageUtil {
	private int pageNum;//���� ������ ��ȣ
	private int startRow; //�������ȣ
	private int endRow; //�����ȣ
	private int totalPageCount; //��ü����������
	private int startPageNum;//������������ȣ
	private int endPageNum; //����������ȣ
	private int rowBlockCount; //���������� ������ ���� ����
	private int pageBlockCount;//���������� ������ �������� ����
	private int totalRowCount;//��ü ���� ����
	
	public PageUtil(){}
	/**
	 * @param pageNum ������������ȣ
	 * @param totalRowCount ��ü���� ����
	 * @param rowBlockCount ������ ���� ����
	 * @param pageBlockCount ������ ������ ����
	 * 
	 */
	public PageUtil(int pageNum,int totalRowCount,int rowBlockCount,int pageBlockCount){
		this.pageNum=pageNum;
		this.totalRowCount=totalRowCount;
		this.rowBlockCount=rowBlockCount;
		this.pageBlockCount=pageBlockCount;
		//�������ȣ
		startRow=(pageNum-1)*rowBlockCount+1;
		//�����ȣ
		endRow=startRow+rowBlockCount-1;
		//��ü����������
		totalPageCount=(int)Math.ceil(totalRowCount/(double)rowBlockCount);
		//������������ȣ
		startPageNum=(pageNum-1)/pageBlockCount*pageBlockCount+1;
		//����������ȣ
		endPageNum=startPageNum+pageBlockCount-1;
		if(totalPageCount<endPageNum){
			endPageNum=totalPageCount;
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public int getRowBlockCount() {
		return rowBlockCount;
	}
	public int getPageBlockCount() {
		return pageBlockCount;
	}
	public int getTotalRowCount() {
		return totalRowCount;
	}
	
}