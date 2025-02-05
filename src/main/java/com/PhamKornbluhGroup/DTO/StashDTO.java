package com.PhamKornbluhGroup.DTO;

public class StashDTO {
    //b Top-Level
    private String id; // Ex: "c5956c281ee71cb55b4737c85524e9094700bab32b425fea1a32aaba4c76f7e8"
    private boolean isPublic; // Ex: "true" //p NOTE: True name "public"
    private String accountName; // Ex: "KeepHopeAlive#7579" //p NOTE: Presumably always ends in #[0-9]{4}
    private String stash; // Ex: "R"
    private StashType stashType; // Ex: "PremiumStash" //p NOTE: Enum should be possible here
    private String league; // Ex: "Standard" //p NOTE: Avoiding enums since there were hundreds of temp/void leagues
    private ItemDTO[] items;

    private enum StashType {
        PREMIUM_STASH // PremiumStash
    }
}
