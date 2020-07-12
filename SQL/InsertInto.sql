use sida;
insert into administrador
values ('admin','123');  

insert into curso 
values ('CTMA','Curso Tecnico em Meio Ambiente na forma Integrada'),
	   ('TADS','Tecnologo em Analise e desenvolvimento de Sistema'),
       ('TELE',' Técnico de Nível Médio em Eletrotécnica na Forma Integrada'),
       ('SETR','Segurança do Trabalho'),
       ('TEED','Técnico de Nível Médio em Edificações');
 
insert into disciplina 
values 	('FIS I','Fisica I',80),
		('MATA','Matemática Aplicada',60),
        ('ED','Estrutura de Dados',80),
        ('ERAS', 'Engenharia de Requisitos e Análise de Software', 80), 
		('FILO', 'Filosofia Aplicada à Computação', 40),
        ('CALI', 'Cálculo I', 40);

insert into disciplina_curso values ('ERAS', 'TADS'), 
									('FILO', 'TEED');            
                            
insert into aluno 
values ('20190001','Philipe Gama'),
	   ('20190002','João Paulo'),
       ('20190003','Drauzio Varela'),
       ('20190004','Mario Paulo'),
       ('20190005','Mario Paulo');
       
insert into professor 
values ('20190001','Thiago Lima','Geografia','123'),
	   ('20190002','Alessandro Negrao','Historia','123'),
       ('20190003','Patricia Nunes','Filosofia','123'),
       ('20190004','Elias Mateus','Fisica','123'),
       ('20190005','Luigi','Biologia','123'),
       ('20190006', 'Jorge Matias', 'Matematica', '123'), 
	   ('20190007', 'Fábio André', 'Inglês', '123'),
	   ('20190008', 'Mohamed Assi', 'Espanhol', '123');
       
insert into disciplina_ofertada
values 	('FIS I',1,'2019-02-11','2019-11-11'),        
        ('FIS I',2,'2019-02-11','2019-11-11'), 
        ('MATA',1,'2019-02-11','2019-11-11');
        
       
insert into disciplina_professor 
values ('20190001','FIS I',1,'2019-02-11'),
	   ('20190002','MATA',1,'2019-02-11'),
	   ('20190001','MATA',1,'2019-02-11');

       
       
insert into turma values('TADS-41', 'TADS-41', 'Matutino'), 
						('TADS-21', 'TADS-21', 'Vespertino');
                        
insert into disciplina_aluno_diagnostico(alumatricula,disosigla,disonumero,disodtinicio)
values ('20190001','FIS I',1,'2019-02-11'),
	   ('20190002','FIS I',1,'2019-02-11');                        
                   
                  
                             
   
                             
                          