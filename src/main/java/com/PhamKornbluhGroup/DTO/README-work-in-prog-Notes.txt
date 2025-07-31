                                                                   dddddddd
RRRRRRRRRRRRRRRRR                                                  d::::::d     MMMMMMMM               MMMMMMMMEEEEEEEEEEEEEEEEEEEEEE
R::::::::::::::::R                                                 d::::::d     M:::::::M             M:::::::ME::::::::::::::::::::E
R::::::RRRRRR:::::R                                                d::::::d     M::::::::M           M::::::::ME::::::::::::::::::::E
RR:::::R     R:::::R                                               d:::::d      M:::::::::M         M:::::::::MEE::::::EEEEEEEEE::::E
  R::::R     R:::::R    eeeeeeeeeeee    aaaaaaaaaaaaa      ddddddddd:::::d      M::::::::::M       M::::::::::M  E:::::E       EEEEEE
  R::::R     R:::::R  ee::::::::::::ee  a::::::::::::a   dd::::::::::::::d      M:::::::::::M     M:::::::::::M  E:::::E
  R::::RRRRRR:::::R  e::::::eeeee:::::eeaaaaaaaaa:::::a d::::::::::::::::d      M:::::::M::::M   M::::M:::::::M  E::::::EEEEEEEEEE
  R:::::::::::::RR  e::::::e     e:::::e         a::::ad:::::::ddddd:::::d      M::::::M M::::M M::::M M::::::M  E:::::::::::::::E
  R::::RRRRRR:::::R e:::::::eeeee::::::e  aaaaaaa:::::ad::::::d    d:::::d      M::::::M  M::::M::::M  M::::::M  E:::::::::::::::E
  R::::R     R:::::Re:::::::::::::::::e aa::::::::::::ad:::::d     d:::::d      M::::::M   M:::::::M   M::::::M  E::::::EEEEEEEEEE
  R::::R     R:::::Re::::::eeeeeeeeeee a::::aaaa::::::ad:::::d     d:::::d      M::::::M    M:::::M    M::::::M  E:::::E
  R::::R     R:::::Re:::::::e         a::::a    a:::::ad:::::d     d:::::d      M::::::M     MMMMM     M::::::M  E:::::E       EEEEEE
RR:::::R     R:::::Re::::::::e        a::::a    a:::::ad::::::ddddd::::::dd     M::::::M               M::::::MEE::::::EEEEEEEE:::::E
R::::::R     R:::::R e::::::::eeeeeeeea:::::aaaa::::::a d:::::::::::::::::d     M::::::M               M::::::ME::::::::::::::::::::E
R::::::R     R:::::R  ee:::::::::::::e a::::::::::aa:::a d:::::::::ddd::::d     M::::::M               M::::::ME::::::::::::::::::::E
RRRRRRRR     RRRRRRR    eeeeeeeeeeeeee  aaaaaaaaaa  aaaa  ddddddddd   ddddd     MMMMMMMM               MMMMMMMMEEEEEEEEEEEEEEEEEEEEEE
-------------------------------------------------------------------------------------------------------------------------------------
Object Hierarchy:
                        ResultDTO
                        └── PublicStashChangeDTO
                            └── ItemDTO
                                ├── ItemSocketDTO
                                ├── ItemDTO                         // (Same as Parent ItemDTO)
Dan MAPPER DONE                 ├── properties (ItemPropertyDTO)
Dan MAPPER DONE                 │   ├── ItemPropertyValuesDTO
N/A                             │   └── DisplayMode (ENUM)
Dan MAPPER DONE                 ├── notableProperties (ItemPropertyDTO)
Dan MAPPER DONE                 │   ├── ItemPropertyValuesDTO
N/A                             │   └── DisplayMode (ENUM)
Dan MAPPER DONE                 ├── requirements (ItemPropertyDTO)
Dan MAPPER DONE                 │   ├── ItemPropertyValuesDTO
N/A                             │   └── DisplayMode (ENUM)
Dan MAPPER DONE                 ├── additionalProperties (ItemPropertyDTO)
Dan MAPPER DONE                 │   ├── ItemPropertyValuesDTO
N/A                             │   └── DisplayMode (ENUM)
Dan MAPPER DONE                 ├── nextLevelRequirements (ItemPropertyDTO)
Dan MAPPER DONE                 │   ├── ItemPropertyValuesDTO
N/A                             │   └── DisplayMode (ENUM)
                                ├── RewardsDTO
                                ├── LogbookModsDTO
                                │   └── FactionDTO
                                │       └── FactionID (ENUM)
                                ├── UltimatumModsDTO
Dan MAPPER DONE                 ├── IncubatedItemDTO
MAPPER DONE                     ├── ScourgedDTO
COMPLETE                        ├── CrucibleDTO
COMPLETE                        │   └── CrucibleNodeDTO
N/A                             ├── FrameType (ENUM)
Dan MAPPER DONE                 ├── HybridDTO
Dan MAPPER DONE                 │   └── properties (ItemPropertyDTO)
Dan MAPPER DONE                 │       ├── ItemPropertyValuesDTO
N/A                             │       └── DisplayMode (ENUM)
Dan MAPPER & SELECT DONE        └── ExtendedDTO
