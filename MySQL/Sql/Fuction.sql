delimiter //
-- -------------------------------------LOGIN PPROFESSOR -------------------------- Básico

drop function if exists fnLoginProfessor//
create function fnLoginProfessor(mat char(14), sen varchar(50))
returns int deterministic
begin
	declare validacao int;
    
    -- verifica se o professor possui uma instancia na base de dados
    
    select count(matricula) into validacao
    from professor
    where matricula = mat and senha = sen;
    
    -- caso seja localizado uma instância, permite o acesso
    
    if validacao != 0 then
		return 1;
	else
		return 0;
	end if;
end//

-- -------------------------------------LOGIN ADMINISTRADOR -------------------------- Básico


drop function if exists fnLoginAdministrador//
create function fnLoginAdministrador(login_p varchar(50), sen varchar(50))
returns int deterministic
begin
	declare validacao int;
    
    -- verifica se o administrador possui instância na tabela monitorando e se a coluna dtfim está nula
    
    select count(login_p) into validacao
    from administrador
	where login = login_p and senha = sen;
    
    
    -- caso seja localizado uma instânciua que cumpra os requisitos anteriores, permite o acesso do monitor
    
    if validacao != 0 then
		return 1;
	else
		return 0;
	end if;
end//

