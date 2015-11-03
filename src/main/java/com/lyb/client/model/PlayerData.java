package com.lyb.client.model;

public class PlayerData {
	// 22:08:27,884 DEBUG commonLogger:15 - Receive [1003_1
	// ]yunyingUserId:f555, userId:2003100012751, userName:莫欺少年穷,
	// career:9000, vip:21420, familyId:2003100000532, familyPositionId:1,
	// familyName:aa1, familyLevel:1, nobility:5,
	// generalIdTableArray:[{configId:28}, {configId:22}, {configId:77},
	// {configId:89}, {configId:10}], lastStrongPointId:10001175, state:3,
	// stage:99999, step:0, level:45, experience:1805, transforId:18,
	// zodiacId:10908

	private long userId;
	private String userName;
	private int career;
	private int level;
	private int experience;
	private int vip;

	private long familyId;
	private int familyPositionId;
	private String familyName;
	private int familyLevel;

	private int nobility;

	private int lastStrongPointId;
	private int state;

	private int stage;
	private int step;

	private int stransforId;
	private int zodiacId;
	
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

	public long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(long familyId) {
		this.familyId = familyId;
	}

	public int getFamilyPositionId() {
		return familyPositionId;
	}

	public void setFamilyPositionId(int familyPositionId) {
		this.familyPositionId = familyPositionId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public int getFamilyLevel() {
		return familyLevel;
	}

	public void setFamilyLevel(int familyLevel) {
		this.familyLevel = familyLevel;
	}

	public int getNobility() {
		return nobility;
	}

	public void setNobility(int nobility) {
		this.nobility = nobility;
	}

	public int getLastStrongPointId() {
		return lastStrongPointId;
	}

	public void setLastStrongPointId(int lastStrongPointId) {
		this.lastStrongPointId = lastStrongPointId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getStransforId() {
		return stransforId;
	}

	public void setStransforId(int stransforId) {
		this.stransforId = stransforId;
	}

	public int getZodiacId() {
		return zodiacId;
	}

	public void setZodiacId(int zodiacId) {
		this.zodiacId = zodiacId;
	}

}
