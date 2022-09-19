graph = {
    'A': ['B', 'C'],
    'B': ['D', ],
    'C': ['F', 'E'],
    'D': ['K', 'E'],
    'E': [],
    'F': ['H'],
    'H': [],
    'K': []
    # 'BB': ['L', 'M', 'N'],
    # 'L': ['K', 'T'],
    # 'O': ['T'],
    # 'M': [],
    # 'N': [],
    # 'K': [],
    # 'T': [],

}

weighted_graph = {
    'Вильнюс': [['Брест', 531], ['Даугавпилс', 211], ['Витебск', 360], ['Калининград', 333], ['Каунас', 102],
                ['Киев', 734]],
    'Витебск': [['Брест', 638], ['Вильнюс', 360], ['Ниж.Новгород', 911], ['Воронеж', 869], ['Волгоград', 1455],
                ['С.Петербург', 602], ['Орел', 522]],
    'Воронеж': [['Витебск', 869], ['Волгоград', 581], ['Ярославль', 739]],
    'Волгоград': [['Витебск', 1455], ['Воронеж', 581], ['Житомир', 1493]],
    'Калининград': [['Брест', 699], ['Вильнюс', 333], ['С.Петербург', 739]],
    'Каунас': [['Вильнюс', 102], ['Рига', 267]],
    'Киев': [['Вильнюс', 734], ['Житомир', 131], ['Кишинев', 467], ['Одесса', 487], ['Харьков', 471]],
    'Житомир': [['Донецк', 863], ['Волгоград', 1493], ['Киев', 131]], 'Кишинев': [['Киев', 467], ['Донецк', 812]],
    'С.Петербург': [['Витебск', 602], ['Калининград', 739], ['Рига', 641], ['Москва', 664], ['Мурманск', 1412]],
    'Москва': [['Казань', 815], ['Ниж.Новгород', 411], ['Минск', 690], ['Донецк', 1084], ['С.Петербург', 664],
               ['Орел', 368]], 'Мурманск': [['С.Петербург', 1412], ['Минск', 2238]],
    'Орел': [['Витебск', 522], ['Донецк', 709], ['Москва', 368]], 'Одесса': [['Киев', 487]],
    'Рига': [['Каунас', 267], ['С.Петербург', 641], ['Таллинн', 308]], 'Таллинн': [['Рига', 308]],
    'Харьков': [['Киев', 471], ['Симферополь', 639]], 'Ярославль': [['Воронеж', 739], ['Минск', 940]],
    'Уфа': [['Казань', 525], ['Самара', 461]], 'Брест': [['Вильнюс', 531], ['Витебск', 638], ['Калининград', 699]],
    'Ниж.Новгород': [['Витебск', 911], ['Москва', 411]], 'Даугавпилс': [['Вильнюс', 211]],
    'Донецк': [['Житомир', 863], ['Кишинев', 812], ['Москва', 1084], ['Орел', 709]],
    'Казань': [['Москва', 815], ['Уфа', 525]], 'Минск': [['Москва', 690], ['Мурманск', 2238], ['Ярославль', 940]],
    'Симферополь': [['Харьков', 639]], 'Самара': [['Уфа', 461]]
}

visited = []
queue = []

stack = []


def DFS_SP(start, goal):
    stack.append(start)
    try:
        DFS(start, goal)
    except Exception:
        print(stack)


def DFS(node, end):
    if node in visited:
        print(stack)
        return
    visited.append(node)
    for nodes in graph[node]:
        stack.append(nodes)
        DFS(nodes, end)
        print(stack)
        if nodes in visited:
            stack.pop()
    if node == end:
        raise Exception("END OF RECURSION!")


def shortest_path_bfs(graph, node1, node2):
    path_list = [[node1]]
    path_index = 0
    # To keep track of previously visited nodes
    previous_nodes = {node1}
    if node1 == node2:
        return path_list[0]

    while path_index < len(path_list):
        current_path = path_list[path_index]
        print(current_path)
        last_node = current_path[-1]
        next_nodes = graph[last_node]
        # Search goal node
        if node2 in next_nodes:
            current_path.append(node2)
            print(path_list)
            return current_path
        # Add new paths
        for next_node in next_nodes:
            if not next_node in previous_nodes:
                new_path = current_path[:]
                new_path.append(next_node)
                path_list.append(new_path)
                # To avoid backtracking
                previous_nodes.add(next_node)
        # Continue to next path in list
        path_index += 1

    # No path is found
    return []


def BFS(node):
    visited.append(node)
    queue.append(node)
    while len(queue) != 0:
        s = queue.pop(0)
        print(s, end=' ')
        for neighbours in graph[s]:
            if neighbours not in visited:
                queue.append(neighbours)
                visited.append(neighbours)


# BFS('A')
# DFS('A')
DFS_SP('A', 'H')
# path_list = [['A']]
# path_list.append(['B', 'C', 'D'])
# print(path_list[0])
# print(shortest_path(graph, 'A', 'T'))
