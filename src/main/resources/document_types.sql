insert into document_types (id, is_macro, code, name, type_description, macro_type_id)
values
    (1, true, 1, 'Report di servizio', null, null),
    (2, false, 2, 'Network', null, 1),
    (3, false, 3, 'Sicurezza', null, 1),
    (4, false, 4, 'Change', null, 1),
    (5, false, 5, 'Backup', null, 1),
    (6, true, 6, 'Report SLA', null, null),
    (7, true, 7, 'Progettazione', null, null),
    (8, false, 8, 'Analisi', null, 7),
    (9, false, 9, 'Transizione', null, 7),
    (10, false, 10, 'Produzione', null, 7),
    (11, false, 11, 'Test', null, 7),
    (12, false, 12, 'Monitoraggio', null, 7);

select
    id,
    name,
    macro_type_id
from document_types;

select
    b.name,
    a.name
from document_types a
         join document_types b
              on a.macro_type_id = b.id
where a.macro_type_id = 7