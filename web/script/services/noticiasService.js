app.service('noticiasService',function($http){
    var noticias = [];
       var noticia = "";
       var $event = "";
 var changeNoticia = function(event,d) {
          $event =  event;
         return noticia = d;
    };  
    
    var noticiasService = {
         getNoticias: function() {
      var promise = $http.get('/betaNewsPTX/betaNewsAPIREST/betaNewsPTXAPI/getNews').then(function (response) {
      noticias = response.data;
      });
      return promise;
    },getList: function() {
       return noticias;
    },
   
  };
      return noticiasService;
    });

