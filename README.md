# Seed BF4 Populate
Seed BF4 para Popular Servidor

# Atualizações EA

A EA frequentemente veem fazendo mudanças na Battlelog, 
quando parar de funcionar precisa entender o que mudou para ajustar o seed.

# Teste realizado hoje: 13/05/2023

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

# Quais contas de BF4 utilizar ?

Somente contas novas sem verificação por e-mail

# Como usar ?

Apesar configurar e executar a classe SeedBF4PopulateTest.

# Porque estou compartilhando ?

Não quero ficar dando manutenção ! :D
