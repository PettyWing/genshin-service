package com.example.uumemory.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class EnKaDO {

    @JSONField(name = "playerInfo")
    private PlayerInfoDTO playerInfo;
    @JSONField(name = "avatarInfoList")
    private List<AvatarInfoListDTO> avatarInfoList;
    @JSONField(name = "ttl")
    private int ttl;
    @JSONField(name = "uid")
    private String uid;

    public PlayerInfoDTO getPlayerInfo() {return playerInfo;}

    public void setPlayerInfo(PlayerInfoDTO playerInfo) {this.playerInfo = playerInfo;}

    public List<AvatarInfoListDTO> getAvatarInfoList() {return avatarInfoList;}

    public void setAvatarInfoList(List<AvatarInfoListDTO> avatarInfoList) {this.avatarInfoList = avatarInfoList;}

    public int getTtl() {return ttl;}

    public void setTtl(int ttl) {this.ttl = ttl;}

    public String getUid() {return uid;}

    public void setUid(String uid) {this.uid = uid;}

    public static class PlayerInfoDTO {
        @JSONField(name = "nickname")
        private String nickname;
        @JSONField(name = "level")
        private int level;
        @JSONField(name = "worldLevel")
        private int worldLevel;
        @JSONField(name = "nameCardId")
        private int nameCardId;
        @JSONField(name = "finishAchievementNum")
        private int finishAchievementNum;
        @JSONField(name = "towerFloorIndex")
        private int towerFloorIndex;
        @JSONField(name = "towerLevelIndex")
        private int towerLevelIndex;
        @JSONField(name = "showAvatarInfoList")
        private List<ShowAvatarInfoListDTO> showAvatarInfoList;
        @JSONField(name = "showNameCardIdList")
        private List<Integer> showNameCardIdList;
        @JSONField(name = "profilePicture")
        private ProfilePictureDTO profilePicture;

        public String getNickname() {return nickname;}

        public void setNickname(String nickname) {this.nickname = nickname;}

        public int getLevel() {return level;}

        public void setLevel(int level) {this.level = level;}

        public int getWorldLevel() {return worldLevel;}

        public void setWorldLevel(int worldLevel) {this.worldLevel = worldLevel;}

        public int getNameCardId() {return nameCardId;}

        public void setNameCardId(int nameCardId) {this.nameCardId = nameCardId;}

        public int getFinishAchievementNum() {return finishAchievementNum;}

        public void setFinishAchievementNum(int finishAchievementNum) {this.finishAchievementNum = finishAchievementNum;}

        public int getTowerFloorIndex() {return towerFloorIndex;}

        public void setTowerFloorIndex(int towerFloorIndex) {this.towerFloorIndex = towerFloorIndex;}

        public int getTowerLevelIndex() {return towerLevelIndex;}

        public void setTowerLevelIndex(int towerLevelIndex) {this.towerLevelIndex = towerLevelIndex;}

        public List<ShowAvatarInfoListDTO> getShowAvatarInfoList() {return showAvatarInfoList;}

        public void setShowAvatarInfoList(List<ShowAvatarInfoListDTO> showAvatarInfoList) {this.showAvatarInfoList = showAvatarInfoList;}

        public List<Integer> getShowNameCardIdList() {return showNameCardIdList;}

        public void setShowNameCardIdList(List<Integer> showNameCardIdList) {this.showNameCardIdList = showNameCardIdList;}

        public ProfilePictureDTO getProfilePicture() {return profilePicture;}

        public void setProfilePicture(ProfilePictureDTO profilePicture) {this.profilePicture = profilePicture;}

        public static class ProfilePictureDTO {
            @JSONField(name = "avatarId")
            private int avatarId;

            public int getAvatarId() {return avatarId;}

            public void setAvatarId(int avatarId) {this.avatarId = avatarId;}
        }

        public static class ShowAvatarInfoListDTO {
            @JSONField(name = "avatarId")
            private int avatarId;
            @JSONField(name = "level")
            private int level;

            public int getAvatarId() {return avatarId;}

            public void setAvatarId(int avatarId) {this.avatarId = avatarId;}

            public int getLevel() {return level;}

            public void setLevel(int level) {this.level = level;}
        }
    }

    public static class AvatarInfoListDTO {
        @JSONField(name = "avatarId")
        private int avatarId;
        @JSONField(name = "propMap")
        private PropMapDTO propMap;
        @JSONField(name = "fightPropMap")
        private FightPropMapDTO fightPropMap;
        @JSONField(name = "skillDepotId")
        private int skillDepotId;
        @JSONField(name = "inherentProudSkillList")
        private List<Integer> inherentProudSkillList;
        @JSONField(name = "skillLevelMap")
        private SkillLevelMapDTO skillLevelMap;
        @JSONField(name = "equipList")
        private List<EquipListDTO> equipList;
        @JSONField(name = "fetterInfo")
        private FetterInfoDTO fetterInfo;
        @JSONField(name = "talentIdList")
        private List<Integer> talentIdList;
        @JSONField(name = "proudSkillExtraLevelMap")
        private ProudSkillExtraLevelMapDTO proudSkillExtraLevelMap;

        public int getAvatarId() {return avatarId;}

        public void setAvatarId(int avatarId) {this.avatarId = avatarId;}

        public PropMapDTO getPropMap() {return propMap;}

        public void setPropMap(PropMapDTO propMap) {this.propMap = propMap;}

        public FightPropMapDTO getFightPropMap() {return fightPropMap;}

        public void setFightPropMap(FightPropMapDTO fightPropMap) {this.fightPropMap = fightPropMap;}

        public int getSkillDepotId() {return skillDepotId;}

        public void setSkillDepotId(int skillDepotId) {this.skillDepotId = skillDepotId;}

        public List<Integer> getInherentProudSkillList() {return inherentProudSkillList;}

        public void setInherentProudSkillList(List<Integer> inherentProudSkillList) {this.inherentProudSkillList = inherentProudSkillList;}

        public SkillLevelMapDTO getSkillLevelMap() {return skillLevelMap;}

        public void setSkillLevelMap(SkillLevelMapDTO skillLevelMap) {this.skillLevelMap = skillLevelMap;}

        public List<EquipListDTO> getEquipList() {return equipList;}

        public void setEquipList(List<EquipListDTO> equipList) {this.equipList = equipList;}

        public FetterInfoDTO getFetterInfo() {return fetterInfo;}

        public void setFetterInfo(FetterInfoDTO fetterInfo) {this.fetterInfo = fetterInfo;}

        public List<Integer> getTalentIdList() {return talentIdList;}

        public void setTalentIdList(List<Integer> talentIdList) {this.talentIdList = talentIdList;}

        public ProudSkillExtraLevelMapDTO getProudSkillExtraLevelMap() {return proudSkillExtraLevelMap;}

        public void setProudSkillExtraLevelMap(ProudSkillExtraLevelMapDTO proudSkillExtraLevelMap) {this.proudSkillExtraLevelMap = proudSkillExtraLevelMap;}

        public static class PropMapDTO {
            @JSONField(name = "1001")
            private _$1001DTO $1001;
            @JSONField(name = "1002")
            private _$1002DTO $1002;
            @JSONField(name = "1003")
            private _$1003DTO $1003;
            @JSONField(name = "1004")
            private _$1004DTO $1004;
            @JSONField(name = "4001")
            private _$4001DTO $4001;
            @JSONField(name = "10010")
            private _$10010DTO $10010;
            @JSONField(name = "10049")
            private _$10049DTO $10049;

            public _$1001DTO get$1001() {return $1001;}

            public void set$1001(_$1001DTO $1001) {this.$1001 = $1001;}

            public _$1002DTO get$1002() {return $1002;}

            public void set$1002(_$1002DTO $1002) {this.$1002 = $1002;}

            public _$1003DTO get$1003() {return $1003;}

            public void set$1003(_$1003DTO $1003) {this.$1003 = $1003;}

            public _$1004DTO get$1004() {return $1004;}

            public void set$1004(_$1004DTO $1004) {this.$1004 = $1004;}

            public _$4001DTO get$4001() {return $4001;}

            public void set$4001(_$4001DTO $4001) {this.$4001 = $4001;}

            public _$10010DTO get$10010() {return $10010;}

            public void set$10010(_$10010DTO $10010) {this.$10010 = $10010;}

            public _$10049DTO get$10049() {return $10049;}

            public void set$10049(_$10049DTO $10049) {this.$10049 = $10049;}

            public static class _$1001DTO {
                @JSONField(name = "type")
                private int type;
                @JSONField(name = "ival")
                private String ival;

                public int getType() {return type;}

                public void setType(int type) {this.type = type;}

                public String getIval() {return ival;}

                public void setIval(String ival) {this.ival = ival;}
            }

            public static class _$1002DTO {
                @JSONField(name = "type")
                private int type;
                @JSONField(name = "ival")
                private String ival;
                @JSONField(name = "val")
                private String val;

                public int getType() {return type;}

                public void setType(int type) {this.type = type;}

                public String getIval() {return ival;}

                public void setIval(String ival) {this.ival = ival;}

                public String getVal() {return val;}

                public void setVal(String val) {this.val = val;}
            }

            public static class _$1003DTO {
                @JSONField(name = "type")
                private int type;
                @JSONField(name = "ival")
                private String ival;

                public int getType() {return type;}

                public void setType(int type) {this.type = type;}

                public String getIval() {return ival;}

                public void setIval(String ival) {this.ival = ival;}
            }

            public static class _$1004DTO {
                @JSONField(name = "type")
                private int type;
                @JSONField(name = "ival")
                private String ival;

                public int getType() {return type;}

                public void setType(int type) {this.type = type;}

                public String getIval() {return ival;}

                public void setIval(String ival) {this.ival = ival;}
            }

            public static class _$4001DTO {
                @JSONField(name = "type")
                private int type;
                @JSONField(name = "ival")
                private String ival;
                @JSONField(name = "val")
                private String val;

                public int getType() {return type;}

                public void setType(int type) {this.type = type;}

                public String getIval() {return ival;}

                public void setIval(String ival) {this.ival = ival;}

                public String getVal() {return val;}

                public void setVal(String val) {this.val = val;}
            }

            public static class _$10010DTO {
                @JSONField(name = "type")
                private int type;
                @JSONField(name = "ival")
                private String ival;
                @JSONField(name = "val")
                private String val;

                public int getType() {return type;}

                public void setType(int type) {this.type = type;}

                public String getIval() {return ival;}

                public void setIval(String ival) {this.ival = ival;}

                public String getVal() {return val;}

                public void setVal(String val) {this.val = val;}
            }

            public static class _$10049DTO {
                @JSONField(name = "type")
                private int type;
                @JSONField(name = "ival")
                private String ival;
                @JSONField(name = "val")
                private String val;

                public int getType() {return type;}

                public void setType(int type) {this.type = type;}

                public String getIval() {return ival;}

                public void setIval(String ival) {this.ival = ival;}

                public String getVal() {return val;}

                public void setVal(String val) {this.val = val;}
            }
        }

        public static class FightPropMapDTO {
            @JSONField(name = "1")
            private double $1;
            @JSONField(name = "2")
            private double $2;
            @JSONField(name = "4")
            private double $4;
            @JSONField(name = "5")
            private double $5;
            @JSONField(name = "6")
            private double $6;
            @JSONField(name = "7")
            private double $7;
            @JSONField(name = "20")
            private double $20;
            @JSONField(name = "21")
            private int $21;
            @JSONField(name = "22")
            private double $22;
            @JSONField(name = "23")
            private double $23;
            @JSONField(name = "26")
            private int $26;
            @JSONField(name = "27")
            private int $27;
            @JSONField(name = "28")
            private double $28;
            @JSONField(name = "29")
            private int $29;
            @JSONField(name = "30")
            private int $30;
            @JSONField(name = "40")
            private int $40;
            @JSONField(name = "41")
            private int $41;
            @JSONField(name = "42")
            private int $42;
            @JSONField(name = "43")
            private double $43;
            @JSONField(name = "44")
            private int $44;
            @JSONField(name = "45")
            private int $45;
            @JSONField(name = "46")
            private int $46;
            @JSONField(name = "50")
            private int $50;
            @JSONField(name = "51")
            private int $51;
            @JSONField(name = "52")
            private int $52;
            @JSONField(name = "53")
            private int $53;
            @JSONField(name = "54")
            private int $54;
            @JSONField(name = "55")
            private int $55;
            @JSONField(name = "56")
            private int $56;
            @JSONField(name = "73")
            private int $73;
            @JSONField(name = "1003")
            private int $1003;
            @JSONField(name = "1010")
            private double $1010;
            @JSONField(name = "2000")
            private double $2000;
            @JSONField(name = "2001")
            private double $2001;
            @JSONField(name = "2002")
            private double $2002;
            @JSONField(name = "2003")
            private int $2003;
            @JSONField(name = "2004")
            private int $2004;
            @JSONField(name = "3006")
            private int $3006;
            @JSONField(name = "3045")
            private int $3045;
            @JSONField(name = "3046")
            private int $3046;

            public double get$1() {return $1;}

            public void set$1(double $1) {this.$1 = $1;}

            public double get$2() {return $2;}

            public void set$2(double $2) {this.$2 = $2;}

            public double get$4() {return $4;}

            public void set$4(double $4) {this.$4 = $4;}

            public double get$5() {return $5;}

            public void set$5(double $5) {this.$5 = $5;}

            public double get$6() {return $6;}

            public void set$6(double $6) {this.$6 = $6;}

            public double get$7() {return $7;}

            public void set$7(double $7) {this.$7 = $7;}

            public double get$20() {return $20;}

            public void set$20(double $20) {this.$20 = $20;}

            public int get$21() {return $21;}

            public void set$21(int $21) {this.$21 = $21;}

            public double get$22() {return $22;}

            public void set$22(double $22) {this.$22 = $22;}

            public double get$23() {return $23;}

            public void set$23(double $23) {this.$23 = $23;}

            public int get$26() {return $26;}

            public void set$26(int $26) {this.$26 = $26;}

            public int get$27() {return $27;}

            public void set$27(int $27) {this.$27 = $27;}

            public double get$28() {return $28;}

            public void set$28(double $28) {this.$28 = $28;}

            public int get$29() {return $29;}

            public void set$29(int $29) {this.$29 = $29;}

            public int get$30() {return $30;}

            public void set$30(int $30) {this.$30 = $30;}

            public int get$40() {return $40;}

            public void set$40(int $40) {this.$40 = $40;}

            public int get$41() {return $41;}

            public void set$41(int $41) {this.$41 = $41;}

            public int get$42() {return $42;}

            public void set$42(int $42) {this.$42 = $42;}

            public double get$43() {return $43;}

            public void set$43(double $43) {this.$43 = $43;}

            public int get$44() {return $44;}

            public void set$44(int $44) {this.$44 = $44;}

            public int get$45() {return $45;}

            public void set$45(int $45) {this.$45 = $45;}

            public int get$46() {return $46;}

            public void set$46(int $46) {this.$46 = $46;}

            public int get$50() {return $50;}

            public void set$50(int $50) {this.$50 = $50;}

            public int get$51() {return $51;}

            public void set$51(int $51) {this.$51 = $51;}

            public int get$52() {return $52;}

            public void set$52(int $52) {this.$52 = $52;}

            public int get$53() {return $53;}

            public void set$53(int $53) {this.$53 = $53;}

            public int get$54() {return $54;}

            public void set$54(int $54) {this.$54 = $54;}

            public int get$55() {return $55;}

            public void set$55(int $55) {this.$55 = $55;}

            public int get$56() {return $56;}

            public void set$56(int $56) {this.$56 = $56;}

            public int get$73() {return $73;}

            public void set$73(int $73) {this.$73 = $73;}

            public int get$1003() {return $1003;}

            public void set$1003(int $1003) {this.$1003 = $1003;}

            public double get$1010() {return $1010;}

            public void set$1010(double $1010) {this.$1010 = $1010;}

            public double get$2000() {return $2000;}

            public void set$2000(double $2000) {this.$2000 = $2000;}

            public double get$2001() {return $2001;}

            public void set$2001(double $2001) {this.$2001 = $2001;}

            public double get$2002() {return $2002;}

            public void set$2002(double $2002) {this.$2002 = $2002;}

            public int get$2003() {return $2003;}

            public void set$2003(int $2003) {this.$2003 = $2003;}

            public int get$2004() {return $2004;}

            public void set$2004(int $2004) {this.$2004 = $2004;}

            public int get$3006() {return $3006;}

            public void set$3006(int $3006) {this.$3006 = $3006;}

            public int get$3045() {return $3045;}

            public void set$3045(int $3045) {this.$3045 = $3045;}

            public int get$3046() {return $3046;}

            public void set$3046(int $3046) {this.$3046 = $3046;}
        }

        public static class SkillLevelMapDTO {
            @JSONField(name = "10781")
            private int $10781;
            @JSONField(name = "10782")
            private int $10782;
            @JSONField(name = "10785")
            private int $10785;

            public int get$10781() {return $10781;}

            public void set$10781(int $10781) {this.$10781 = $10781;}

            public int get$10782() {return $10782;}

            public void set$10782(int $10782) {this.$10782 = $10782;}

            public int get$10785() {return $10785;}

            public void set$10785(int $10785) {this.$10785 = $10785;}
        }

        public static class FetterInfoDTO {
            @JSONField(name = "expLevel")
            private int expLevel;

            public int getExpLevel() {return expLevel;}

            public void setExpLevel(int expLevel) {this.expLevel = expLevel;}
        }

        public static class ProudSkillExtraLevelMapDTO {
            @JSONField(name = "2532")
            private int $2532;
            @JSONField(name = "2539")
            private int $2539;

            public int get$2532() {return $2532;}

            public void set$2532(int $2532) {this.$2532 = $2532;}

            public int get$2539() {return $2539;}

            public void set$2539(int $2539) {this.$2539 = $2539;}
        }

        public static class EquipListDTO {
            @JSONField(name = "itemId")
            private int itemId;
            @JSONField(name = "reliquary")
            private ReliquaryDTO reliquary;
            @JSONField(name = "flat")
            private FlatDTO flat;
            @JSONField(name = "weapon")
            private WeaponDTO weapon;

            public int getItemId() {return itemId;}

            public void setItemId(int itemId) {this.itemId = itemId;}

            public ReliquaryDTO getReliquary() {return reliquary;}

            public void setReliquary(ReliquaryDTO reliquary) {this.reliquary = reliquary;}

            public FlatDTO getFlat() {return flat;}

            public void setFlat(FlatDTO flat) {this.flat = flat;}

            public WeaponDTO getWeapon() {return weapon;}

            public void setWeapon(WeaponDTO weapon) {this.weapon = weapon;}

            public static class ReliquaryDTO {
                @JSONField(name = "level")
                private int level;
                @JSONField(name = "mainPropId")
                private int mainPropId;
                @JSONField(name = "appendPropIdList")
                private List<Integer> appendPropIdList;

                public int getLevel() {return level;}

                public void setLevel(int level) {this.level = level;}

                public int getMainPropId() {return mainPropId;}

                public void setMainPropId(int mainPropId) {this.mainPropId = mainPropId;}

                public List<Integer> getAppendPropIdList() {return appendPropIdList;}

                public void setAppendPropIdList(List<Integer> appendPropIdList) {this.appendPropIdList = appendPropIdList;}
            }

            public static class FlatDTO {
                @JSONField(name = "nameTextMapHash")
                private String nameTextMapHash;
                @JSONField(name = "setNameTextMapHash")
                private String setNameTextMapHash;
                @JSONField(name = "rankLevel")
                private int rankLevel;
                @JSONField(name = "reliquaryMainstat")
                private ReliquaryMainstatDTO reliquaryMainstat;
                @JSONField(name = "reliquarySubstats")
                private List<ReliquarySubstatsDTO> reliquarySubstats;
                @JSONField(name = "itemType")
                private String itemType;
                @JSONField(name = "icon")
                private String icon;
                @JSONField(name = "equipType")
                private String equipType;

                public String getNameTextMapHash() {return nameTextMapHash;}

                public void setNameTextMapHash(String nameTextMapHash) {this.nameTextMapHash = nameTextMapHash;}

                public String getSetNameTextMapHash() {return setNameTextMapHash;}

                public void setSetNameTextMapHash(String setNameTextMapHash) {this.setNameTextMapHash = setNameTextMapHash;}

                public int getRankLevel() {return rankLevel;}

                public void setRankLevel(int rankLevel) {this.rankLevel = rankLevel;}

                public ReliquaryMainstatDTO getReliquaryMainstat() {return reliquaryMainstat;}

                public void setReliquaryMainstat(ReliquaryMainstatDTO reliquaryMainstat) {this.reliquaryMainstat = reliquaryMainstat;}

                public List<ReliquarySubstatsDTO> getReliquarySubstats() {return reliquarySubstats;}

                public void setReliquarySubstats(List<ReliquarySubstatsDTO> reliquarySubstats) {this.reliquarySubstats = reliquarySubstats;}

                public String getItemType() {return itemType;}

                public void setItemType(String itemType) {this.itemType = itemType;}

                public String getIcon() {return icon;}

                public void setIcon(String icon) {this.icon = icon;}

                public String getEquipType() {return equipType;}

                public void setEquipType(String equipType) {this.equipType = equipType;}

                public static class ReliquaryMainstatDTO {
                    @JSONField(name = "mainPropId")
                    private String mainPropId;
                    @JSONField(name = "statValue")
                    private double statValue;

                    public String getMainPropId() {return mainPropId;}

                    public void setMainPropId(String mainPropId) {this.mainPropId = mainPropId;}

                    public double getStatValue() {return statValue;}

                    public void setStatValue(double statValue) {this.statValue = statValue;}
                }

                public static class ReliquarySubstatsDTO {
                    @JSONField(name = "appendPropId")
                    private String appendPropId;
                    @JSONField(name = "statValue")
                    private double statValue;

                    public String getAppendPropId() {return appendPropId;}

                    public void setAppendPropId(String appendPropId) {this.appendPropId = appendPropId;}

                    public double getStatValue() {return statValue;}

                    public void setStatValue(double statValue) {this.statValue = statValue;}
                }
            }

            public static class WeaponDTO {
                @JSONField(name = "level")
                private int level;
                @JSONField(name = "promoteLevel")
                private int promoteLevel;
                @JSONField(name = "affixMap")
                private AffixMapDTO affixMap;

                public int getLevel() {return level;}

                public void setLevel(int level) {this.level = level;}

                public int getPromoteLevel() {return promoteLevel;}

                public void setPromoteLevel(int promoteLevel) {this.promoteLevel = promoteLevel;}

                public AffixMapDTO getAffixMap() {return affixMap;}

                public void setAffixMap(AffixMapDTO affixMap) {this.affixMap = affixMap;}

                public static class AffixMapDTO {
                    @JSONField(name = "111424")
                    private int $111424;

                    public int get$111424() {return $111424;}

                    public void set$111424(int $111424) {this.$111424 = $111424;}
                }
            }
        }
    }
}
