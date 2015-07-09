// Copyright (c) 2014 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

var bulkDataListener = null;

extension.setMessageListener(function(msg) {
  if (bulkDataListener instanceof Function) {
    bulkDataListener(msg);
  };
});

exports.sendBulkDataAsync = function (msg, callback) {
  bulkDataListener = callback;
  extension.postMessage(msg);
};

exports.sendBulkDataSync = function (msg) {
  return extension.internal.sendSyncMessage(msg);
};

