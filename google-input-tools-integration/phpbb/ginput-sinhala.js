  // Load the Google Transliteration API
  google.load("elements", "1",
  {
  	packages: "transliteration"
  });

  function onLoad()
  {
  	var options = {
  		sourceLanguage: 'en',
  		destinationLanguage: ['si'],
  		shortcutKey: 'ctrl+m',
  		transliterationEnabled: true
  	}

  	// Create an instance on TransliterationControl with the required options.
  	var control = new google.elements.transliteration.TransliterationControl(options);

  	// Enable transliteration in the textfields with the given ids.
  	var ids = ["message", "subject"];
  	var valid_ids = ids.filter(e => !!document.getElementById(e));
  	if (valid_ids.length > 0)
  	{
  		control.makeTransliteratable(valid_ids);
  	}
  }

  google.setOnLoadCallback(onLoad);
