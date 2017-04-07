# dev-01

## MVP pattern

![mvp](https://cloud.githubusercontent.com/assets/12447492/24792857/06af403a-1b80-11e7-96cd-503a50d6830e.png)

<b>View:</b> dumb layer which is in charge of displaying UI components with their respective data, listening to user interactions (events) and dispatching them to the presentaer layer.

<b>Presenter:</b> a proxy layer that handles received user events and dispatch actions to the model based on the received events.

<b>Model:</b> a data layer which is in charge of manipulating data, getting it from the cloud or the local storage.

## Packages

![packages](https://cloud.githubusercontent.com/assets/12447492/24792926/44c41b84-1b80-11e7-88e1-a78d13b9ed52.png)

We tend to create a package for each feature (use case) in order to decouple them from each othere e.g forecasts, forecastdetails. Data package holds models and repositories for local storage. Network package holds remote API services. The rest of the packages (common and util) are for common use.

## Sequence diagram

The following sequence diagram describes the interaction between MVP components for the use case "forecasts" (which loads a list of forecasts):

![seq](https://cloud.githubusercontent.com/assets/12447492/24792953/57de62ce-1b80-11e7-8ea6-7cfb3ad1c3c8.png)
