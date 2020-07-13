use sida;
-----------------------------------------------------------
----------------------  PROFESSOR  ---------------------
-----------------------------------------------------------
DELIMITER $$
drop procedure if exists cadastrarProfessor $$
create procedure cadastrarProfessor (in promatricula char(14), 
                                     in pronome varchar(80),
									 in proformacao varchar(50),
                                     in prosenha varchar(50))
begin
	insert into professor values(promatricula,pronome,proformacao,prosenha);
end $$
DELIMITER ;


DELIMITER $$
drop procedure if exists consultarProfessorSigla $$
create procedure consultarProfessorSigla (in p_buscar char(14))
begin
	select * from professor where promatricula = p_buscar;
end $$
DELIMITER ;


DELIMITER $$
drop procedure if exists consultarProfessor $$
create procedure consultarProfessor (in p_buscar varchar(80))
begin
	select * from professor where promatricula like concat(p_buscar,'%') or pronome like concat(p_buscar,'%') ;
end $$
DELIMITER ;



DELIMITER $$
drop procedure if exists consultarProfessorAluno $$
create procedure consultarProfessorAluno(in p_disosigla char(14),in p_numero int,in p_promatricula char(14))
begin
	select alumatricula,alunome,dissigla,disodtinicio from professor 
	inner join disciplina_professor on dprpromatricula = promatricula
	inner join disciplina_ofertada on disosigla = dprdisosigla and disonumero = dprdisonumero and disotinicio = dprdisodtinicio
	inner join disciplina_aluno_diagnostico on disosigla = daddisosigla and disonumero = daddisonumero and disodtinicio = daddisodtinicio
	inner join aluno on dadalumatricula = alumatricula
    where do1.dissigla = p_disosigla
    and disonumero = p_numero
    and promatricula = p_promatricula;
	
     
end $$
DELIMITER ;



DELIMITER $$
drop procedure if exists consultarDisciplinaProfessor $$
create procedure consultarDisciplinaProfessor (in p_promatricula char(14))
begin
	select disosigla,disonumero,disodtinicio from professor
	inner join disciplina_professor on dprpromatricula = promatricula
	inner join disciplina_ofertada on disodissigla = dprdisosigla and disonumero = dprdisonumero and disodtinicio = dprdisodtinicio
    where promatricula = p_promatricula;
    
end $$
DELIMITER ;



DELIMITER $$
drop procedure if exists excluirProfessor $$
create procedure excluirProfessor (in p_matricula char(14))
begin
	delete from professor where promatricula = p_matricula;
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists alterarProfessor $$
create procedure alterarProfessor (in p_matricula char(14), 
                                   in p_nome varchar(80),
                                   in p_formacao varchar(45))
begin
	update professor 
    set 
		  pronome = p_nome,
		  proformacao = p_formacao 
    where promatricula = p_matricula;
end $$
DELIMITER ;

-----------------------------------------------------------
-----------------  DISCIPLINA PROFESSOR  -------------------
-----------------------------------------------------------

DELIMITER $$
drop procedure if exists cadastrarDisciplinaProfessor $$
create procedure cadastrarDisciplinaProfessor (in dprpromatricula char(14), 
									  in dprdisosigla char(14),
									  in dprdisonumero int,
                                      in dprdisodtinicio date)
begin
	insert into disciplinacurso values(dprpromatricula,dprdisosigla,dprdisonumero,dprdisodtinicio);
end $$
DELIMITER ;

-----------------------------------------------------------
----------------------  ALUNO  ----------------------------
-----------------------------------------------------------

DELIMITER $$
drop procedure if exists cadastrarAluno $$
create procedure cadastrarAluno (in matricula char(14), 
                                 in nome varchar(80))
begin
	insert into aluno values(matricula,nome);
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists consultarAluno $$
create procedure consultarAluno (in p_nome varchar(80))
begin
	select * from aluno where alunome like concat(p_nome,'%');
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists excluirAluno $$
create procedure excluirAluno (in p_matricula char(14))
begin
	delete from aluno where alumatricula = p_matricula;
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists alterarAluno $$
create procedure alterarAluno (in p_matricula char(14), 
							    in p_nome varchar(80))
begin
	update aluno 
    set 
		  alunome = p_nome		  
    where alumatricula = p_matricula;
end $$
DELIMITER ;

-----------------------------------------------------------
-----------------  DISCIPLINA ALUNO  -------------------
-----------------------------------------------------------

DELIMITER $$
drop procedure if exists cadastrarDisciplinaAluno $$
create procedure cadastrarDisciplinaAluno (in p_alumatricula char(14), 
									  in p_disosigla char(14),
									  in p_disonumero int,
                                      in p_disodtinicio date)
begin
	insert into disciplinacurso(dadalumatricula,daddisosigla,daddisonumero,daddisodtinicio) values(p_alumatricula,p_disosigla,p_disonumero,p_disodtinicio);
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists consultarDisciplinaAluno $$
create procedure consultarDisciplinaAluno (in p_matricula varchar(80))
begin
	select * from curso where curdescricao like concat(p_descricao,'%') or sigla like concat(p_descricao,'%');
end $$
DELIMITER ;


-----------------------------------------------------------
-----------------------  CURSO  ---------------------------
-----------------------------------------------------------

DELIMITER $$
drop procedure if exists cadastrarCurso $$
create procedure cadastrarCurso (in sigla char(14), 
                                 in descricao varchar(80))
begin
	insert into curso values(sigla,descricao);
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists consultarSiglaCurso $$
create procedure consultarSiglaCurso (in p_sigla varchar(80))
begin
	select * from curso where cursigla = p_sigla;
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists consultarDescricaoCurso $$
create procedure consultarDescricaoCurso (in p_descricao varchar(80))
begin
	select * from curso where curdescricao like concat(p_descricao,'%') or cursigla like concat(p_descricao,'%');
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists excluirCurso $$
create procedure excluirCurso (in p_sigla char(14))
begin
	delete from curso where cursigla = p_sigla;
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists alterarCurso $$
create procedure alterarCurso (in p_sigla char(14), 
							    in p_descricao varchar(80))
begin
	update curso 
    set 
		  curdescricao = p_descricao		  
    where cursigla = p_sigla;
end $$
DELIMITER ;

-----------------------------------------------------------
----------------------  DISCIPLINA  -----------------------
-----------------------------------------------------------
DELIMITER $$
drop procedure if exists cadastrarDisciplina $$
create procedure cadastrarDisciplina (in sigla char(14), 
									  in descricao varchar(80),
									  in cargahoraria int)
begin
	insert into disciplina values(sigla,descricao,cargahoraria);
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists consultarSiglaDisciplina $$
create procedure consultarSiglaDisciplina (in p_sigla char(14))
begin
	select * from disciplina where dissigla = p_sigla;
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists consultarDescricaoDisciplina $$
create procedure consultarDescricaoDisciplina (in p_descricao varchar(80))
begin
	select * from disciplina where disdescricao like concat('%',p_descricao,'%');
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists excluirDisciplina $$
create procedure excluirDisciplina (in p_sigla char(14))
begin
	delete from disciplina where dissigla = p_sigla;
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists alterarDisciplina $$
create procedure alterarDisciplina (in p_sigla char(14), 
									in p_descricao varchar(80),
									in p_cargahoraria int)
begin
	update disciplina 
    set 
		  disdescricao = p_descricao,		
          discargahoraria = p_cargahoraria
    where dissigla = p_sigla;
end $$
DELIMITER ;

-----------------------------------------------------------
-----------------  DISCIPLINA CURSO  ----------------------
-----------------------------------------------------------
DELIMITER $$
drop procedure if exists cadastrarDisciplinaCurso $$
create procedure cadastrarDisciplinaCurso (in dissigla char(14), 
									  in cursigla char(14))
begin
	insert into disciplina_curso values (dissigla,cursigla);
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists consultarSiglaDisciplinaCurso $$
create procedure consultarSiglaDisciplinaCurso (in p_dissigla varchar(14))
begin
	select * from disciplina_curso where dcdissigla = p_dissigla;
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists excluirDisciplinaCurso $$
create procedure excluirDisciplinaCurso (in p_dissigla char(14),in p_cursigla char(14))
begin
	delete from disciplina_curso where dcdissigla = p_dissigla and dccursigla = p_cursigla;
end $$
DELIMITER ;

-----------------------------------------------------------
-----------------  DISCIPLINA OFERTADA  -------------------
-----------------------------------------------------------
DELIMITER $$
drop procedure if exists cadastrarDisciplinaOfertada $$
create procedure cadastrarDisciplinaOfertada (in dissigla char(14), 
									  in numero int,
									  in dtinicio date,
                                      in dtfim date)
begin
	insert into disciplina_ofertada values(dissigla,numero,dtinicio,dtfim);
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists consultarSiglaDisciplinaOfertada $$
create procedure consultarSiglaDisciplinaOfertada (in p_dissigla varchar(14))
begin
	select * from disciplina_ofertada where disosigla like concat(p_dissigla,'%');
end $$
DELIMITER ;

-----------------------------------------------------------
-----------------  DIAGNOSTICO  ---------------------------
-----------------------------------------------------------
DELIMITER $$
drop procedure if exists cadastrarDiagnostico $$
create procedure cadastrarDiagnostico (in p_desempenho int, 
									  in p_comportamento int,
									  in p_frequencia int,
                                      in p_pontualidade int,
                                      in p_problema varchar(100),
                                      in p_superacao varchar(100),
                                      in p_disosigla char(14),
                                      in p_disonumero int,
                                      in p_disodtinicio date,
                                      in p_alumatricula char(14) )
begin
	insert into disciplina_aluno_diagnostico
    values(p_desempenho,p_comportamento,p_frequencia,p_pontualidade,p_problema,p_superacao,p_disosigla,p_disonumero,p_disodtinicio,p_alumatricula);
    insert into disciplina_aluno_diagnostico
    values(p_desempenho,p_comportamento,p_frequencia,p_pontualidade,p_problema,p_superacao,p_disosigla,p_disonumero,p_disodtinicio,p_alumatricula);
end $$
DELIMITER ;

DELIMITER $$
drop procedure if exists updateDiagnostico $$
create procedure updateDiagnostico (in p_desempenho int, 
									  in p_comportamento int,
									  in p_frequencia int,
                                      in p_pontualidade int,
                                      in p_problema varchar(100),
                                      in p_superacao varchar(100),
                                      in p_disosigla char(14),
                                      in p_disonumero int,
                                      in p_disodtinicio date,
                                      in p_alumatricula char(14) )
begin
	update disciplina_aluno_diagnostico
    set daddesempenho = p_desempenho, dadcomportamento = p_comportamento, dadfrequencia = p_frequencia, 
    dadproblema = p_problema, dadsuperacao = p_superacao
    where daddisosigla = p_disosigla and
    daddisonumero = p_disonumero and
    dadalumatricula = p_alumatricula;
    
end $$
DELIMITER ;



DELIMITER $$
drop procedure if exists consultarSiglaDisciplinaOfertada $$
create procedure consultarSiglaDisciplinaOfertada (in p_dissigla varchar(14))
begin
	select * from disciplina_ofertada where disosigla like concat(p_dissigla,'%');
end $$
DELIMITER ;




DELIMITER $$
drop procedure if exists consultarDiagnosticoProfessor $$
create procedure consultarDiagnosticoProfessor(in p_promatricula char(14))
begin
	select alumatricula,daddesempenho,dadcomportamento,
    dadfrenquecia,dadpontualidade,dadproblema,dadsuperacao,
    daddisosigla,daddisonumero,daddisodtinicio,dadalumatricula
    from professor p
	inner join disciplina_professor on dprpromatricula = promatricula
	inner join disciplina_ofertada on disosigla = dprdisosigla and disonumero = dprdisonumero and disodtinicio = dprdisodtinicio
	inner join disciplina_aluno_diagnostico dad on disosigla = daddisosigla and disonumero = daddisonumero and disodtinicio = daddisodtinicio
	inner join aluno a on dad.alumatricula = a.matricula
    and promatricula = p_promatricula; 
end $$
DELIMITER ;
