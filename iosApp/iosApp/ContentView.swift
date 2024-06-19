import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

	var body: some View {
        NavigationView {
            listView()
            .navigationBarTitle("SpaceX Launches")
            .navigationBarItems(trailing:
                Button("Reload") {
                    self.viewModel.loadLaunches()
            })
        }
    }
    
    private func listView() -> AnyView {
            switch viewModel.launches {
            case .loading:
                return AnyView(Text("Loading...").multilineTextAlignment(.center))
            case .result(let launches):
                return AnyView(Text("Data came -> \(launches.count)").multilineTextAlignment(.center))
            case .error(let description):
                return AnyView(Text(description).multilineTextAlignment(.center))
            }
        }
}

extension ContentView {
    enum LoadableLaunches {
        case loading
        case result([RocketLaunch])
        case error(String)
    }
    
    @MainActor
    class ViewModel: ObservableObject {
        @Published var launches = LoadableLaunches.loading
        
        
        init() {
            self.loadLaunches()
        }
        
        func loadLaunches() {
            Task {
                do {
                    self.launches = .loading
                    let launches = try await SpaceXRepo().getAllLaunches()
                    self.launches = .result(launches)
                } catch {
                    self.launches = .error(error.localizedDescription)
                }
            }
        }
    }
}
