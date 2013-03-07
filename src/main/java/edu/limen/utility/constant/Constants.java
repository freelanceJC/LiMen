package edu.limen.utility.constant;

public class Constants {
	
	public static final byte GROUPING_STATUS_ACTIVE = 1;
	public static final byte GROUPING_STATUS_ANYONE_CAN_SEE_MEMBER_LIST = 2;
	public static final byte GROUPING_STATUS_ANYONE_CAN_SEE_MEMBER_LIST_AND_EVENT = 4;
	public static final short GROUPING_STATUS_FRIEND_LIST = 128;

	public static final byte USER_GROUPING_STATUS_INVITED_TO_BE_FRIEND  = 1;
	public static final byte USER_GROUPING_STATUS_FRIEND  = 2;
	public static final byte USER_GROUPING_STATUS_NOT_AVAILABLE_IN_FRIEND_LIST  = 4;
	public static final byte USER_GROUPING_STATUS_FRIEND_LIST_OWNER  = 8;
	public static final byte USER_GROUPING_STATUS_AWAITING_ACCEPTANCE  = 32;
	public static final byte USER_GROUPING_STATUS_IGNORE  = 64;
	public static final short USER_GROUPING_STATUS_RECEIVE_GROUP_NOTIFICATION  = 128;
}
