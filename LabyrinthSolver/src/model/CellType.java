package model;

public enum CellType {
	FREE, WALL, START, FINISH;
	
	public String toString(){
		switch(this){
		case FREE:		return "free";
		case WALL:		return "wall";
		case START:		return "start";
		case FINISH:	return "finish";
		default:		return "unknown";
		}
	}
}
