# Seed BF4 Populate

BF4 Seed for Popular Server

# EA updates

EA often sees making changes to Battlelog,
when it stops working need to understand what changed to adjust the seed.

# Test performed today: 05/13/2023

- RequestOpenBattlelog status : 200
- Found Regex Url Login: true
- RequestLoginPage status : 200
- RequestAuthentication status : 200
- Found Regex Url Redirect: true
- RequestRedirectAuthentication status : 200
- RequestRequestGameId status : 200
- Found Regex GameId: true
- Found Regex PersonalId: true
- Found Regex PostChecksum: true
- gameId : 18014398529247748
- personaId : XXXX
- postChecksum : XXXX
- RequestJoinServer status : 200
- ResponseBody status : {"type":"success","message":"RESERVATION", "data":{"gameId":"18014398529247748","userId":"XXX",
- "invitePersona":null,"game":2048,"sourceGuid":"8aa7c9b2-7b57-4ef2-b463-b680548f06d0","expirationTimeout":60,"personaId":"XXXX",
- "voipAllowed":true,"platform":1,"role":1,"gameServer":null,"joinState":"JOINED_GAME"}}
- RequestExitServer status : 200
- ResponseBody status : {"type":"success","message":"CANCELED","data":{}}

# Which BF4 accounts to use?

Only new accounts without email verification

# How to use ?

Just configure and run the SeedBF4PopulateTest class.

# Why am I sharing?

I don't want to be doing maintenance! :D
