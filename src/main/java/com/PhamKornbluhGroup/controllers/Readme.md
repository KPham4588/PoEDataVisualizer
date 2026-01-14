item -> random_item
price -> stash name is "~ 10 chaos"

select stash.name, item.*
from item
inner join stash on item.stashID = stash.dbID

get public stash change dto -> only populate a subset
that contains a mageblood
filter by league