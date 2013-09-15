1- Lister les catégories qui n'ont pas d'article:

select * from categories cat where cat.cat_id not in(select art.cat_id from articles art);

2- La catégorie qui a le plus d'articles: