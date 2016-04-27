(function() {
	'use strict';
    angular
        .module('app.fundtransfer')
        .factory('FundTransferService', FundTransferService);

    /* @ngInject */
    function FundTransferService($http) {
    var service = {
        getNewInternalFundtransfer: getNewInternalFundtransfer,
        getPendingFundTransfers: getPendingFundTransfers,
        getFundTransferDetails: getFundTransferDetails,
        getTransactionStatusCodes: getTransactionStatusCodes,
        getProductStatusCodes: getProductStatusCodes
    };
    return service;
    
    function getNewInternalFundtransfer(){
       return $http.get('/ft/new').then(getCompleteHandler);
        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
    }
    
    function getPendingFundTransfers(tnxStatCode) {
        return $http.post('/ft/list', {tnxStatCode:tnxStatCode}).then(getCompleteHandler);
            function getCompleteHandler(response) {
                return response.data;
            }
    }
    
    function getFundTransferDetails(rid) {
        return $http.post('/ft/query', {rid:rid}).then(getCompleteHandler);
            function getCompleteHandler(response) {
                return response.data;
            }
    }
    
    function getTransactionStatusCodes() {
        var statusCodes = [
            {'code': '03', 'value': 'Submitted (Pending for Approval)'},
            {'code': '04', 'value': 'Approved'},
            {'code': '01', 'value': 'Rejected'}
        ];
        return statusCodes;
    }
    
    function getProductStatusCodes() {
        var statusCodes = [
            {'code': '03', 'value': 'Approved'},
            {'code': '01', 'value': 'Not Processed'},
        ];
        return statusCodes;
    }
}
})();