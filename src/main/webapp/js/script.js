function font_change(element){
    var list_of_elem = document.getElementsByClassName("sort");
    for(var i=0; i<list_of_elem.length; i++){
        list_of_elem[i].style.fontFamily = "TrixieCyr-Light";
    }
    element.style.fontFamily = "TrixieCyr-Cameo";
}

function sorting(sort_string) {
    var array_of_cardSets = Array.prototype.slice.call(document.getElementsByClassName("card_set"));
    var array_of_cards = Array.prototype.slice.call(document.querySelectorAll("ul.card_set li.card"));
    var sort_tag = sort_string.getAttribute("data-sort-tag");
    for(var i=0; i<array_of_cards.length; i++){
        array_of_cards[i].parentNode.removeChild(array_of_cards[i]);
    }
    var array_of_h2 =  Array.prototype.slice.call(document.querySelectorAll("div.table p.decoration_title"));
    for(i=0; i<array_of_h2.length; i++){
        array_of_h2[i].parentNode.removeChild(array_of_h2[i]);
    }
    array_of_h2 = [];
//должен делить по признаку этажа
    if (sort_tag == "sort_by_floor"){

        var map_of_floors = new Map();
        fillMap(map_of_floors,"p.floor");
        var array_of_floors = Array.from(map_of_floors);
        array_of_floors.sort(function (a, b) {
            var floorA = a[0];
            var floorB = b[0];
            if (floorA > floorB) {
                return 1;
            }
            if (floorA < floorB) {
                return -1;
            }
            return 0; });
        joinElements(array_of_floors);

    }
//должен делить по признаку группы
    if (sort_tag == "sort_by_group"){

        var map_of_group = new Map();
        fillMap(map_of_group,"p.member");
        var array_of_memberships = Array.from(map_of_group);
        array_of_memberships.sort(function (a, b) {
            var floorA = a[0];
            var floorB = b[0];
            if (floorA > floorB) {
                return 1;
            }
            if (floorA < floorB) {
                return -1;
            }
            return 0; });
        joinElements(array_of_memberships);
    }
//должен чистить все деления и выдавать по алфавиту
    if (sort_tag == "sort_by_al"){

        array_of_cards.sort(function (a, b) {
            var floorA = a.querySelector("p").textContent;
            var floorB = b.querySelector("p").textContent;
            if (floorA > floorB) {
                return 1;
            }
            if (floorA < floorB) {
                return -1;
            }
            return 0; });

        for(i=0; i<array_of_cardSets.length; i++){
            for( j=0; j<3; j++){
                if(array_of_cards.length==0){break}
                array_of_cardSets[i].appendChild(array_of_cards.shift())
            }
        }
    }

    array_of_cardSets = Array.prototype.slice.call(document.getElementsByClassName("card_set"));
    for(var item of array_of_cardSets){
        if(item.querySelectorAll("li.card").length == 0){item.parentNode.removeChild(item);}
    }

    function fillMap(map,selector){
        for( var card of array_of_cards){
            var floor = card.querySelector(selector).textContent;
            var array_for_map = [];
            if(map.has(floor)){
                array_for_map = map.get(floor);}
            array_for_map.push(card);
            map.set(floor,array_for_map);
        }
    }
    function joinElements(array){
        for (var item of array){
            i = 0;
            var cardSet;
            var root = document.getElementsByClassName("table")[0];
            var footer = document.getElementsByClassName("decoration_last")[0];
            var isFirst = true;
            for(var card of item[1]){
                if(i==0){
                    if(array_of_cardSets.length != 0){
                        cardSet = array_of_cardSets.shift();
                    } else{
                        var ul = document.createElement("ul");
                        ul.className = "card_set";
                        root.insertBefore(ul,footer);
                        //добавлять до нижней полоски
                        cardSet = ul;
                    }
                }
                if(isFirst){
                    isFirst = false;
                    var p = document.createElement('p');
                    p.innerHTML = item[0];
                    p.className = "decoration_title";
                    root.insertBefore(p,cardSet);}
                cardSet.appendChild(card);
                i++;
                if(i==3){ i=0;}
            }
        }
    }
}

function search(search_form) {
    //сделать анимацию светления

    var string = search_form.value;
    var array_of_cards = Array.prototype.slice.call(document.getElementsByClassName("card"));
    var newClass = "fade";
    for(var card of array_of_cards){
        var i = card.querySelector("p.name").textContent.indexOf(string);
        var classList = card.classList;
        if((i!=-1)&&(classList.contains(newClass))){
            classList.remove(newClass)
        } else if((i==-1)&&(!classList.contains(newClass))){
            classList.add(newClass)
        }
    }
}