package fedata.gcnwii.fe9;

import java.util.Arrays;

import fedata.general.FEModifiableData;
import util.WhyDoesJavaNotHaveThese;

public class FE9Class implements FEModifiableData {

	private byte[] originalData;
	private byte[] data;
	
	private long originalOffset;
	
	private Boolean wasModified = false;
	private Boolean hasChanges = false;
	
	private Long cachedClassIDPointer;
	private Long cachedNameIDPointer;
	private Long cachedDescriptionIDPointer;
	
	private Long cachedPromotedIDPointer;
	private Long cachedDefaultWeaponPointer;
	private Long cachedWeaponLevelPointer;
	
	private Long cachedSkill1Pointer;
	private Long cachedSkill2Pointer;
	private Long cachedSkill3Pointer;
	
	private Long cachedRacePointer;
	private Long cachedMiscPointer;
	
	private Long cachedAnimationPointer;
	
	public FE9Class(byte[] data, long originalOffset) {
		super();
		this.originalData = data;
		this.data = data;
		this.originalOffset = originalOffset;
	}
	
	public long getClassIDPointer() {
		if (cachedClassIDPointer == null) {
			cachedClassIDPointer = readPointerAtOffset(0x0);
		}
		return cachedClassIDPointer;
	}
	
	public long getClassNamePointer() {
		if (cachedNameIDPointer == null) {
			cachedNameIDPointer = readPointerAtOffset(0x4);
		}
		return cachedNameIDPointer;
	}
	
	public long getClassDescriptionPointer() {
		if (cachedDescriptionIDPointer == null) {
			cachedDescriptionIDPointer = readPointerAtOffset(0x8);
		}
		return cachedDescriptionIDPointer;
	}
	
	public long getPromotionIDPointer() {
		if (cachedPromotedIDPointer == null) {
			cachedPromotedIDPointer = readPointerAtOffset(0xC);
		}
		return cachedPromotedIDPointer;
	}
	
	public long getDefaultWeaponPointer() {
		if (cachedDefaultWeaponPointer == null) {
			cachedDefaultWeaponPointer = readPointerAtOffset(0x10);
		}
		return cachedDefaultWeaponPointer;
	}
	
	public long getWeaponLevelPointer() {
		if (cachedWeaponLevelPointer == null) {
			cachedWeaponLevelPointer = readPointerAtOffset(0x14);
		}
		return cachedWeaponLevelPointer;
	}
	
	public long getSkill1Pointer() {
		if (cachedSkill1Pointer == null) {
			cachedSkill1Pointer = readPointerAtOffset(0x18);
		}
		return cachedSkill1Pointer;
	}
	
	public long getSkill2Pointer() {
		if (cachedSkill2Pointer == null) {
			cachedSkill2Pointer = readPointerAtOffset(0x1C);
		}
		return cachedSkill2Pointer;
	}
	
	public long getSkill3Pointer() {
		if (cachedSkill3Pointer == null) {
			cachedSkill3Pointer = readPointerAtOffset(0x20);
		}
		return cachedSkill3Pointer;
	}
	
	public long getRacePointer() {
		if (cachedRacePointer == null) {
			cachedRacePointer = readPointerAtOffset(0x2C);
		}
		return cachedRacePointer;
	}
	
	public long getMiscPointer() {
		if (cachedMiscPointer == null) {
			cachedMiscPointer = readPointerAtOffset(0x30);
		}
		return cachedMiscPointer;
	}
	
	public long getAnimationPointer() {
		if (cachedAnimationPointer == null) {
			cachedAnimationPointer = readPointerAtOffset(0x38);
		}
		return cachedAnimationPointer;
	}
	
	public byte[] getUnknown8Bytes() {
		return Arrays.copyOfRange(data, 0x3C, 0x3C + 8);
	}
	
	// The first byte in the unknown 8 bytes seems to be the class's base CON.
	public int getBaseCON() {
		return data[0x3C];
	}
	
	// The second byte in the unknown 8 bytes seems to be the class's base weight.
	public int getBaseWeight() {
		return data[0x3C + 1];
	}
	
	// The 4th byte in the unknown 8 bytes seems to be the skill capacity for the class.
	// That's at offset 0x3C + 4
	public int getSkillCapacity() {
		return data[0x3C + 3];
	}
	
	public int getBaseHP() { return data[0x44]; }
	public int getBaseSTR() { return data[0x45]; }
	public int getBaseMAG() { return data[0x46]; }
	public int getBaseSKL() { return data[0x47]; }
	public int getBaseSPD() { return data[0x48]; }
	public int getBaseLCK() { return data[0x49]; }
	public int getBaseDEF() { return data[0x4A]; }
	public int getBaseRES() { return data[0x4B]; }
	
	public int getMaxHP() { return data[0x4C]; }
	public int getMaxSTR() { return data[0x4D]; }
	public int getMaxMAG() { return data[0x4E]; }
	public int getMaxSKL() { return data[0x4F]; }
	public int getMaxSPD() { return data[0x50]; }
	public int getMaxLCK() { return data[0x51]; }
	public int getMaxDEF() { return data[0x52]; }
	public int getMaxRES() { return data[0x53]; }
	
	public int getHPGrowth() { return data[0x54]; }
	public void setHPGrowth(int newGrowth) { data[0x54] = (byte)(newGrowth & 0xFF); wasModified = true; }
	public int getSTRGrowth() { return data[0x55]; }
	public void setSTRGrowth(int newGrowth) { data[0x55] = (byte)(newGrowth & 0xFF); wasModified = true; }
	public int getMAGGrowth() { return data[0x56]; }
	public void setMAGGrowth(int newGrowth) { data[0x56] = (byte)(newGrowth & 0xFF); wasModified = true; }
	public int getSKLGrowth() { return data[0x57]; }
	public void setSKLGrowth(int newGrowth) { data[0x57] = (byte)(newGrowth & 0xFF); wasModified = true; }
	public int getSPDGrowth() { return data[0x58]; }
	public void setSPDGrowth(int newGrowth) { data[0x58] = (byte)(newGrowth & 0xFF); wasModified = true; }
	public int getLCKGrowth() { return data[0x59]; }
	public void setLCKGrowth(int newGrowth) { data[0x59] = (byte)(newGrowth & 0xFF); wasModified = true; }
	public int getDEFGrowth() { return data[0x5A]; }
	public void setDEFGrowth(int newGrowth) { data[0x5A] = (byte)(newGrowth & 0xFF); wasModified = true; }
	public int getRESGrowth() { return data[0x5B]; }
	public void setRESGrowth(int newGrowth) { data[0x5B] = (byte)(newGrowth & 0xFF); wasModified = true; }
	
	public byte[] getLaguzData() {
		return Arrays.copyOfRange(data, 0x5C, 0x5C + 8);
	}
	
	private long readPointerAtOffset(int offset) {
		byte[] ptr = Arrays.copyOfRange(data, offset, offset + 4);
		if (WhyDoesJavaNotHaveThese.byteArraysAreEqual(ptr, new byte[] {0, 0, 0, 0})) { return 0; }
		
		return WhyDoesJavaNotHaveThese.longValueFromByteArray(ptr, false) + 0x20;
	}
	
	private void writePointerToOffset(long pointer, int offset) {
		byte[] ptr = pointer == 0 ? new byte[] {0, 0, 0, 0} : WhyDoesJavaNotHaveThese.bytesFromPointer(pointer - 0x20);
		WhyDoesJavaNotHaveThese.copyBytesIntoByteArrayAtIndex(ptr, data, offset, 4);
	}
	
	public void resetData() {
		data = originalData;
		wasModified = false;
	}
	
	public void commitChanges() {
		if (wasModified) {
			hasChanges = true;
		}
		wasModified = false;
	}
	
	public Boolean hasCommittedChanges() {
		return hasChanges;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public Boolean wasModified() {
		return wasModified;
	}
	
	public long getAddressOffset() {
		return originalOffset;
	}
}
