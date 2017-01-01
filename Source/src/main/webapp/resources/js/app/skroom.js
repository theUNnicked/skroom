/**
 * Adds or updates GET parameter, and reloads page.
 * 
 * @author Wojciech Stanisławski
 * @since 31.12.16
 */
function addOrChangeGetParameterAndReload(param, value) {
    if(document.URL.search(param+"=") < 0) {
        var separator = (document.URL.indexOf('?') > -1) ? '&' : '?';
        window.location.href = document.URL + separator + param + "=" + value;
    }
    else {
        window.location.href = document.URL.replace(new RegExp(param + "[=]\\d*"), param + "=" + value);
    }
}

/**
 * Reads value of a GET parameter.
 * 
 * @author Wojciech Stanisławski
 * @since 31.12.16
 */
function takeGETParamValue(param) {
    var loc = document.URL.search(new RegExp(param + "[=]\\d*"));
    if (loc > 0) {
        var shortUrl = document.URL.substr(loc);
        var endLoc = shortUrl.indexOf("&");
        if(endLoc < 0) {
            return parseInt(shortUrl.substr(shortUrl.indexOf("=") + 1));
        }
        else {
            return parseInt(shortUrl.substr(shortUrl.indexOf("=") + 1, shortUrl.indexOf("&") - shortUrl.indexOf("=")));
        }
    }
    else {
        return undefined;
    }
}

/**
 * Method for selecting element in <select> list by supplied value.
 * 
 * @author Wojciech Stanisławski
 * @since 05.12.16
 */
function searchForOptionInSelectAndCheckIfEquals(children, value) {
    var i;
    for(i = 0; i < children.length; i++) {
        var child = children[i];
        if(child.value == value) {
            child.setAttribute("selected", true);
            return;
        }
    }
}
/**
 * Selects current values in user story form <select> elements.
 * 
 * @author Wojciech Stanisławski
 * @since 05.12.16
 */
function reloadUserStoryForm(storyPoints, storyStatus) {
    if(storyPoints != undefined) {
        var select = document.getElementById("story-points-select");
        searchForOptionInSelectAndCheckIfEquals(select.children, storyPoints);
        
    }
    if(storyPoints != undefined) {
        var select = document.getElementById("user-story-status-select");
        searchForOptionInSelectAndCheckIfEquals(select.children, storyStatus);
    }
}

function reloadEditUserForm(role) {
    if (role != undefined) {
        var select = document.getElementById("select-edit-user-role");
        searchForOptionInSelectAndCheckIfEquals(select.children, role);
    }
}

/**
 * Saves in database how many user stories user wants to display.
 * 
 * @author Wojciech Stanisławski
 * @since 05.12.16
 */
function saveUserStoriesPerPage(value) {
    $.ajax({
        type : "POST",
        data : { 'perPage': value },
        url : "rest/userSettings/userStoriesPerPage",
        complete : function(response) {
            location.reload();
        }
    });
}

/**
 * Saves in database which project is selected.
 * 
 * @author Wojciech Stanisławski
 * @since 05.12.16
 */
function selectProject(value) {
    $.ajax({
        type : "POST",
        url : "rest/userSettings/selectProject",
        data: {"projectId": value},
        complete : function(response) {
            location.reload();
        }
    });
}

/**
 * Closes ongoing sprint.
 * 
 * @author Wojciech Stanisławski
 * @since 06.12.16
 */
function closeCurrentSprint() {
    $.ajax({
        type : "POST",
        url : "rest/sprints/close",
        complete : function(response) {
            location.reload();
        }
    });
}

/**
 * Closes ongoing sprint.
 * 
 * @author Wojciech Stanisławski
 * @since 06.12.16
 */
function createNewSprint(elementId) {
    var name = $("#" + elementId).val();
    
    $.ajax({
        type : "POST",
        url : "rest/sprints/create",
        data: {"name": name},
        complete : function(response) {
            location.reload();
        }
    });
}

/**
 * Selects current values in task form <select> elements.
 * 
 * @author Wojciech Stanisławski
 * @since 05.12.16
 */
function reloadTaskForm(taskStatus) {
    if(taskStatus != undefined) {
        var select = document.getElementById("task-status-select");
        searchForOptionInSelectAndCheckIfEquals(select.children, taskStatus);
        
    }
}

/**
 * Selects sprint using menu in management bar.
 * 
 * @author Wojciech Stanisławski
 * @since 31.12.16
 */
function selectSprintInMenu(select) {
    var value = select.options[select.selectedIndex].value;
    var param = "spr";
    addOrChangeGetParameterAndReload(param, value);
}

/**
 * Selects sprint in <select> tag based on URL.
 * 
 * @author Wojciech Stanisławski
 * @since 31.12.16
 */
function reloadSprintForm(selectId) {
    if(takeGETParamValue("spr") != undefined) {
        searchForOptionInSelectAndCheckIfEquals(document.getElementById(selectId).children, takeGETParamValue("spr"));
    }
}