(function() {
	'use strict';
    angular
        .module('app.accounts')
        .factory('AccountService', AccountService);

    /* @ngInject */
    function AccountService($http) {
    var service = {
        getCustomerAccounts: getCustomerAccounts
    };
    return service;
    
    function getCustomerAccounts(orgId){
       return $http.post('/customeraccount/list', {customerOrgId:orgId}).then(getCompleteHandler);

        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
       
    }
    
}
})();