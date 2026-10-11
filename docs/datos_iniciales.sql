USE db_recursos;

INSERT INTO recursos_digitales (titulo, autor, tipo, formato, url_archivo, descargas) VALUES
  ('Don Quijote de la Mancha', 'Miguel de Cervantes', 'EBOOK', 'PDF', '/recursos/don-quijote.pdf', 0),
  ('Frankenstein', 'Mary Shelley', 'EBOOK', 'EPUB', '/recursos/frankenstein.epub', 0),
  ('Attention Is All You Need', 'Ashish Vaswani et al.', 'ARTICULO', 'PDF', '/recursos/attention-is-all-you-need.pdf', 0),
  ('A Mathematical Theory of Communication', 'Claude Shannon', 'ARTICULO', 'PDF', '/recursos/teoria-matematica-comunicacion.pdf', 0),
  ('Communications of the ACM', 'ACM', 'REVISTA', 'PDF', '/recursos/communications-acm.pdf', 0);